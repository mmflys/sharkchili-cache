package com.shark.cache.cache;

import com.shark.cache.consts.CacheConfigConst;
import com.shark.util.util.PropertyUtil;

import java.util.Properties;

/**
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public abstract class AbstractConfig implements Config{
	private String host;
	private int port;

	public AbstractConfig(Properties properties){
		PropertyUtil.checkNotNull(properties, CacheConfigConst.CACHE_HOST);
		this.host=properties.getProperty(CacheConfigConst.CACHE_HOST);
		PropertyUtil.checkNotNull(properties, CacheConfigConst.CACHE_PORT);
		this.port=Integer.parseInt(properties.getProperty(CacheConfigConst.CACHE_PORT));
		setConfig(properties);
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	/**
	 * Customer set config in addition to host and port
	 * @param properties config file
	 */
	protected abstract void setConfig(Properties properties);
}
