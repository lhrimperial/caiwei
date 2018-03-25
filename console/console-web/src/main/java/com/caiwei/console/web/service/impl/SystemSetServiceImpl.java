package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.business.service.IRoleService;
import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.web.domain.RoleVO;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.ISystemSetService;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.cryp.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 **/
@Service
public class SystemSetServiceImpl implements ISystemSetService {

    @Autowired
    private IPermisUserService permisUserService;

    @Autowired
    private IRoleService roleService;

    @Override
    public UserVO queryUserList(UserVO userVO) {
        userVO.setUserDOS(permisUserService.findUsers(userVO.getUserDO(), userVO.getPageNo(), userVO.getPageSize()));
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
    public RoleVO queryRoleList(RoleVO roleVO) {
        roleVO.setRoleDOS(roleService.findByParam(roleVO.getRoleDO(), roleVO.getPageNo(), roleVO.getPageSize()));
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
