package com.caiwei.console.business.cache;

import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.common.domain.ResourceNode;
import com.caiwei.console.persistent.mapper.ResourceMapper;
import com.github.framework.server.cache.provider.ITTLCacheProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * 功能权限缓存数据提供对象
 */
@Component
public class ResourceMenuCacheProvider implements ITTLCacheProvider<List<ResourceNode>> {
	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public List<ResourceNode> get(String key) {
		List<ResourceDO> res = resourceMapper.findByParentCode(key);
		List<ResourceNode> resMenus = new ArrayList<>(res.size());
		for (ResourceDO re : res) {
			resMenus.add(re.convert(re));
		}
		return resMenus;
	}
}
