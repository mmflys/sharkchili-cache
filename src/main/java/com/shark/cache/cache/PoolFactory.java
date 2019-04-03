package com.shark.cache.cache;

import com.shark.cache.cache.redis.RedisConfig;
import com.shark.cache.cache.redis.RedisPool;
import com.shark.cache.exception.CacheAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Properties;

/**
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public class PoolFactory {
	private static final Logger LOGGER= LoggerFactory.getLogger(PoolFactory.class);

	/**
	 * Get a pool according to the properties and type
	 * @param properties config file
	 * @param type application type
	 * @return a instance of cache pool
	 */
	public static Pool pool(Properties properties,CacheAppType type){
		switch (type){
			case REDIS:{
				Config config=new RedisConfig(properties);
				Pool<JedisPool, Jedis> pool=new RedisPool(config);
				LOGGER.info("create a {} pool",CacheAppType.REDIS);
				return pool;
			}
			case APP:{
				LOGGER.info("create a {} pool",CacheAppType.APP);
				return null;
			}
		}
		throw new CacheAppException("cache app type %s is error",type);
	}

}
