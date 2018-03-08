package com.caiwei.console.business.cache;

import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.common.domain.ResourceNode;
import com.caiwei.console.persistent.mapper.ResourceMapper;
import com.github.framework.server.cache.provider.ITTLCacheProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 */
@Component
public class ResourceCodeCacheProvider implements ITTLCacheProvider<ResourceDO> {
	@Autowired
	private ResourceMapper resourceMapper;
	@Override
	public ResourceDO get(String key) {
		return resourceMapper.findByResCode(key);
	}

}
