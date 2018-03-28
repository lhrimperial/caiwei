package com.caiwei.console.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.caiwei.console.business.service.IDepartmentService;
import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.business.service.IRoleService;
import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.common.domain.RoleDO;
import com.caiwei.console.common.domain.UserRoleDO;
import com.caiwei.console.common.util.ConvertUtil;
import com.caiwei.console.web.domain.RoleVO;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.ISystemSetService;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.cryp.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 **/
@Service
public class SystemSetServiceImpl implements ISystemSetService {

    @Autowired
    private IPermisUserService permisUserService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IDepartmentService departmentService;

    @Override
    public UserVO findUserById(UserVO userVO) {
        if (userVO == null) {
            throw new BusinessException("参数不能为空！");
        }
        List<PermisUserDO> users = permisUserService.findUsers(userVO.getUserDO());
        if (users != null && users.size() > 0) {
            PermisUserDO userDO = users.get(0);
            userDO.setActive(ConvertUtil.statusToActive(userDO.getStatus()));
            userVO.setUserDO(userDO);
        }
        return userVO;
    }

    @Override
    public UserVO queryUserList(UserVO userVO) {
        userVO.setUserDOS(permisUserService.findUsers(userVO.getUserDO(), userVO.getPageNo(), userVO.getPageSize()));
        userVO.setTotalCount(permisUserService.totalCount(userVO.getUserDO()));
        return userVO;
    }

    @Override
    public void addUser(UserVO userVO) {
        PermisUserDO permisUserDO = userVO.getUserDO();
        permisUserDO.setPassWord(CryptoUtil.getInstance().getMD5ofStr(permisUserDO.getPassWord()));
        permisUserDO.setStatus(Constants.PO_ACTIVE);
        permisUserDO.setCreateTime(new Date());
        permisUserDO.setModifyTime(new Date());
        permisUserService.save(permisUserDO);
    }

    @Override
    public void updateUser(UserVO userVO) {
        permisUserService.update(userVO.getUserDO());
    }

    @Override
    public void deleteUser(UserVO userVO) {
        List<String> userCodes = userVO.getUserCodes();
        permisUserService.updateStatus(userCodes, Constants.PO_INACTIVE);
        permisUserService.updateUserRoleStatus(userCodes, Constants.PO_INACTIVE);
    }

    @Override
    public UserVO queryUserDept(UserVO userVO) {
        if (userVO != null ) {
            DepartmentDO departmentDO = new DepartmentDO();
            departmentDO.setCurrUserCode(userVO.getUserCode());
            List<DepartmentDO> list = departmentService.findByParams(departmentDO);
            userVO.setDepartmentDOS(list);
        }
        return userVO;
    }

    @Override
    public RoleVO queryOrgRoleByUserCode(UserVO userVO) {
        RoleVO roleVO = new RoleVO();
        if (userVO != null && userVO.getUserDO() != null) {
            PermisUserDO userDO = userVO.getUserDO();
            List<RoleDO> roleDOS = roleService.queryOrgRoleByUserCode(userDO.getUserCode(), userDO.getDeptCode());
            roleVO.setRoleDOS(roleDOS);
        }
        return roleVO;
    }

    @Override
    public RoleVO queryAllRole(RoleVO roleVO) {
        roleVO.setRoleDOS(roleService.findByParam(roleVO.getRoleDO(), 0, 0));
        return roleVO;
    }

    @Override
    public void updateUserOrgRole(UserVO userVO) {
        if (userVO == null) {
            throw new BusinessException("参数不能为空!");
        }
        PermisUserDO userDO = userVO.getUserDO();
        String userCode = userDO.getUserCode();
        String deptCode = userDO.getDeptCode();
        Set<String> roleCodes = userDO.getRoleCodes();
        List<UserRoleDO> userRoleDOS = new ArrayList<>(roleCodes.size());
        UserRoleDO userRoleDO = null;
        for (String roleCode : roleCodes) {
            userRoleDO = new UserRoleDO(userCode,deptCode,roleCode);
            userRoleDO.setCreateTime(new Date());
            userRoleDO.setModifyTime(new Date());
            userRoleDO.setStatus(Constants.PO_ACTIVE);
            userRoleDOS.add(userRoleDO);
        }
        roleService.deleteUserRole(userCode, deptCode);
        roleService.batchSaveUserRole(userRoleDOS);
    }

    @Override
    public RoleVO queryRoleList(RoleVO roleVO) {
        roleVO.setRoleDOS(roleService.findByParam(roleVO.getRoleDO(), roleVO.getPageNo(), roleVO.getPageSize()));
        roleVO.setTotalCount(roleService.totalCount(roleVO.getRoleDO()));
        return roleVO;
    }

    @Override
    public void addRole(RoleVO roleVO) {
        roleService.save(roleVO.getRoleDO());
    }

    @Override
    public RoleVO findRole(RoleVO roleVO) {
        roleVO.setRoleDO(roleService.findById(roleVO.getRoleDO().getTid()));
        return roleVO;
    }

    @Override
    public void updateRole(RoleVO roleVO) {
        roleService.update(roleVO.getRoleDO());
    }

    @Override
    public void deleteRole(RoleVO roleVO) {
        roleService.updateStatus(roleVO.getRoleCodes(), Constants.PO_INACTIVE);
    }
}
