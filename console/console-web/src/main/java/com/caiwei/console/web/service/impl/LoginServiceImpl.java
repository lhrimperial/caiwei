package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IDepartmentService;
import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.common.context.PermisUserContext;
import com.caiwei.console.common.define.ConsoleConstants;
import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.common.exception.LoginException;
import com.caiwei.console.common.exception.UserException;
import com.caiwei.console.web.domain.DepartmentVO;
import com.caiwei.console.web.domain.LoginInfoVO;
import com.caiwei.console.web.domain.cookie.Cookie;
import com.caiwei.console.web.service.ILoginService;
import com.github.framework.server.context.SessionContext;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.cryp.CryptoUtil;
import com.github.framework.util.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 */
@Service
public class LoginServiceImpl implements ILoginService {

    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private IPermisUserService permisUserService;

    @Autowired
    private IDepartmentService departmentService;

    @Override
    public void logout() {
        /**
         * 失效当前session
         */
        SessionContext.invalidateSession();
    }

    @Override
    public PermisUserDO userLogin(String userCode, String password) {
        //验证用户
        PermisUserDO userDO = validate(userCode, password);
        // 把登录用户ID、工号与默认部门编码存入session中
        SessionContext.setCurrentUser(userDO.getUserCode());
        SessionContext.getSession().setObject(ConsoleConstants.KEY_CURRENT_EMPCODE, userDO.getEmpCode());
        SessionContext.getSession().setObject(ConsoleConstants.KEY_CURRENT_DEPTCODE, userDO.getDeptCode());
        SessionContext.getSession().setObject(ConsoleConstants.KEY_CURRENT_DEPTNAME, userDO.getEmployeeDO().getDeptName());
        return userDO;
    }

    @Override
    public LoginInfoVO currentLoginUserInfo() {
        LoginInfoVO loginInfoVO = new LoginInfoVO();
        loginInfoVO.setCurrentUser(PermisUserContext.getCurrentUser());
        loginInfoVO.setCurrentServerTime(new Date());
        String deptCode = (String) SessionContext.getSession().getObject(ConsoleConstants.KEY_CURRENT_DEPTCODE);
        if (StringUtils.isNotBlank(deptCode)) {
            DepartmentDO departmentDO = departmentService.findByDeptCode(deptCode);
            loginInfoVO.setCurrentDept(departmentDO);
        }
        return loginInfoVO;
    }

    @Override
    public DepartmentVO currentUserDepts(String deptName) {
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setCurrUserCode(PermisUserContext.getCurrentUser().getUserCode());
        departmentDO.setDeptName(deptName);

        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.setDepartmentDOS(departmentService.findByParams(departmentDO));
        departmentVO.setTotalCount(departmentService.totalCount(departmentDO));
        return departmentVO;
    }

    @Override
    public void changeCurrentUserDept(String deptCode) {
        if (StringUtils.isEmpty(deptCode)) {
            throw new LoginException(LoginException.CURRENT_DEPT_ISNOT_EXIST);
        }
        DepartmentDO departmentDO = departmentService.findByDeptCode(deptCode);
        SessionContext.getSession().setObject(ConsoleConstants.KEY_CURRENT_DEPTCODE, departmentDO.getDeptCode());
        SessionContext.getSession().setObject(ConsoleConstants.KEY_CURRENT_DEPTNAME, departmentDO.getDeptName());
        Cookie.saveCookie();
    }

    @Override
    public DepartmentVO findCurrUserByParams(String deptName) {
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setCurrUserCode(PermisUserContext.getCurrentUser().getUserCode());
        departmentDO.setDeptName(deptName);

        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.setDepartmentDOS(departmentService.findCurrUserByParams(departmentDO));
        departmentVO.setTotalCount(departmentService.currUserTotalCount(departmentDO));
        return departmentVO;
    }

    private PermisUserDO validate(String userName, String password)
            throws LoginException, UserException {
        if (StringUtils.isBlank(userName)) {
            throw new LoginException(LoginException.USER_NAME_NULL);
        }
        if (StringUtils.isBlank(password)) {
            throw new LoginException(LoginException.USER_PASSWORD_NULL);
        }
        // 应用OA的加密方式
        password = CryptoUtil.getInstance().getMD5ofStr(password);
        PermisUserDO userPO = permisUserService.findUserByLoginCode(userName);
        if (userPO == null) {
            throw new LoginException(LoginException.USER_NULL);
        }
        // 如果用户已经被禁用，则不能登录
        if (Constants.PO_ACTIVE != userPO.getStatus()) {
            throw new LoginException(LoginException.USER_DISABLE);
        }
        if (!password.equals(userPO.getPassWord())) {
            throw new LoginException(LoginException.USER_PASSWORD_ERROR);
        }
         //通过用户ID得到用户的完整信息
        userPO = permisUserService.findUserDetail(userName);
        // 如果用户为空，则用户没有配置角色
        if (userPO == null) {
            throw new LoginException(LoginException.CURRENT_USER_NO_ROLE);
        }
        return userPO;
    }
}
