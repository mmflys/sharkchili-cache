package com.shark.cache.consts;

/**
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public class CacheConfigConst {
	public static final String CONFIG_FILE="application.properties";

	// cache application attribute
	public static final String
			CACHE_HOST="cache.host",
			CACHE_PORT ="cache.port";

	public static final String CACHE_APP_TYPE="cacheConfig.cacheAppType";

	// redis config attribute
	public static final String
			REDIS_PASSWORD ="cacheConfig.redis.password",
			REDIS_TIMEOUT ="cacheConfig.redis.timeout";
}
