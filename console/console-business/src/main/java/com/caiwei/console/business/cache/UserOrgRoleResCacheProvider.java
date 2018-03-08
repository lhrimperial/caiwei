package com.caiwei.console.business.cache;

import com.caiwei.console.common.domain.UserOrgResCodeUrisDO;
import com.caiwei.console.persistent.mapper.UserMapper;
import com.github.framework.server.cache.provider.ITTLCacheProvider;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户部门角色权限缓存数据提供者
 */
@Component
public class UserOrgRoleResCacheProvider implements ITTLCacheProvider<List<Set<String>>> {

	@Resource
	private UserMapper userMapper;

	@Override
	public List<Set<String>> get(String key) {
		String[] strs = key.split("#");
		String userCode = strs[0];
		String deptCode  = strs[1];
		List<Set<String>> listInfo = queryOrgResCodeUrisByCode(userCode, deptCode);
		return listInfo;
	}
	
	private List<Set<String>> queryOrgResCodeUrisByCode(String userCode, String deptCode){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Set<String>> result = new ArrayList<Set<String>>();
		Set<String> uriSet = new HashSet<String>();
		Set<String> codeSet = new HashSet<String>();
		map.put("userCode", userCode);
		map.put("deptCode", deptCode);

		List<UserOrgResCodeUrisDO> orgCodeAndRoleCodes = userMapper.queryOrgResCodeUrisByCode(map);
		for(UserOrgResCodeUrisDO entity : orgCodeAndRoleCodes){
			uriSet.add(entity.getResUri());
			codeSet.add(entity.getResCode());
		}
		result.add(codeSet);
		result.add(uriSet);
		return result;
	}
}
