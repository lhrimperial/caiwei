package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.IUserService;
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
public class UserServiceImpl implements IUserService {

    @Autowired
    private IPermisUserService permisUserService;

    @Override
    public UserVO queryUserList(UserVO userVO) {
        UserVO userVO1 = new UserVO();
        userVO1.setUserDOS(permisUserService.findUsers(userVO.getUserDO()));
        return userVO1;
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
    public void deleteUser(UserVO userVO) {
        List<String> userCodes = userVO.getUserCodes();
        permisUserService.updateStatus(userCodes, Constants.PO_INACTIVE);
    }
}
