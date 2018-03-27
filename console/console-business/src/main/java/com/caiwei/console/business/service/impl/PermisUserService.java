package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.cache.UserCache;
import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.common.util.ConvertUtil;
import com.caiwei.console.persistent.domain.UserPO;
import com.caiwei.console.persistent.mapper.UserMapper;
import com.caiwei.console.persistent.mapper.UserRoleMapper;
import com.github.framework.server.cache.CacheManager;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.serializer.BeanCopyUtils;
import com.github.framework.util.string.StringUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class PermisUserService implements IPermisUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int save(PermisUserDO permisUserDO) {
        UserPO userPO = new UserPO();
        BeanCopyUtils.copyBean(permisUserDO, userPO);
        if (userPO.getCreateTime() == null) {
            userPO.setCreateTime(new Date());
        }
        if (userPO.getModifyTime() == null) {
            userPO.setModifyTime(new Date());
        }
        return userMapper.insert(userPO);
    }

    @Override
    public int update(PermisUserDO permisUserDO) {
        UserPO userPO = new UserPO();
        BeanCopyUtils.copyBean(permisUserDO, userPO);
        if (userPO.getModifyTime() == null) {
            userPO.setModifyTime(new Date());
        }
        if (StringUtils.isNotBlank(userPO.getActive())) {
            userPO.setStatus(ConvertUtil.activeToStatus(userPO.getActive()));
        }
        return userMapper.update(userPO);
    }

    @Override
    public int delete(String userCode) {
        UserPO userPO = new UserPO(userCode, Constants.PoStatus.INACTIVE.value());
        return userMapper.update(userPO);
    }

    @Override
    public PermisUserDO findUserByLoginCode(String userCode) {
        return userMapper.findUserByLoginCode(userCode);
    }

    @Override
    public PermisUserDO findUserDetail(String userCode) {
        PermisUserDO user = (PermisUserDO) CacheManager.getInstance()
                .getCache(UserCache.CACHE_NAME).get(userCode);
        return user;
    }

    @Override
    public List<PermisUserDO> findUsers(PermisUserDO userDO, int pageNo, int pageSize) {
        if (userDO != null) {
            userDO.setStatus(ConvertUtil.activeToStatus(userDO.getActive()));
        }
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.findUsers(userDO);
    }

    @Override
    public List<PermisUserDO> findUsers(PermisUserDO userDO) {
        if (userDO != null) {
            userDO.setStatus(ConvertUtil.activeToStatus(userDO.getActive()));
        }
        return userMapper.findUsers(userDO);
    }

    @Override
    public void updateStatus(List<String> userCodes, Byte status) {
        userMapper.updateStatus(userCodes, status);
    }

    @Override
    public void updateUserRoleStatus(List<String> userCodes, Byte status) {
        userRoleMapper.updateStatus(userCodes, status);
    }
}
