package com.shark.cache.cache;

import com.shark.cache.exception.ConfigException;
import com.shark.container.common.ConfigConst;

/**
 * Description cache application type
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public enum CacheAppType implements ConfigConst {
	NULL("null"),
	APP("app"),
	REDIS("redis");

	String typeName;

	CacheAppType(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * Get default type
	 * @return a instance of  CacheAppType
	 */
	public static CacheAppType defaultTYpe(){
		return APP;
	}

	public String getTypeName() {
		return typeName;
	}

	@Override
	public CacheAppType getByName(String typeName){
		for (CacheAppType value : CacheAppType.values()) {
			if (value.typeName.equals(typeName)){
				return value;
			}
		}
		throw new ConfigException("cache app type name %s config error",typeName);
	}

	@Override
	public ConfigConst getDefault() {
		return APP;
	}
}
