package com.shark.cache.cache.redis;

import com.shark.cache.cache.AbstractConfig;
import com.shark.cache.consts.CacheConfigConst;
import com.shark.cache.consts.CacheConfigDefault;
import com.shark.util.util.PropertyUtil;

import java.util.Properties;

/**
 * Redis config
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public class RedisConfig extends AbstractConfig {

	private String password;
	private Integer timeout;

	public RedisConfig(Properties properties) {
		super(properties);
	}

	@Override
	protected void setConfig(Properties properties) {
		PropertyUtil.checkNotNull(properties, CacheConfigConst.REDIS_PASSWORD);
		this.password=properties.getProperty(CacheConfigConst.REDIS_PASSWORD);
		PropertyUtil.doIfNullOrDefault(properties, CacheConfigConst.REDIS_TIMEOUT,
				v->this.timeout= Integer.parseInt(v.toString()), CacheConfigDefault.REDIS_TIMEOUT);
	}

	String getPassword() {
		return password;
	}

	public Integer getTimeout() {
		return timeout==null? CacheConfigDefault.REDIS_TIMEOUT:timeout;
	}
}
