package com.shark.cache.cache.redis;

import com.shark.cache.cache.AbstractPool;
import com.shark.cache.cache.Config;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis pool
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public class RedisPool extends AbstractPool<JedisPool,Jedis> {

	/**config*/
	private Config config;

	public RedisPool(Config config) {
		super(config);
	}

	@Override
	public Jedis getMyResource() {
		return getAppPool().getResource();
	}

	@Override
	public void setAppPool(Config config) {
		RedisConfig redisConfig= (RedisConfig) config;
		this.appPool= new JedisPool(new JedisPoolConfig(), redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout());
		this.config=config;
	}

	@Override
	public void auth(Jedis jedis) {
		RedisConfig redisConfig= (RedisConfig) config;
		jedis.auth(redisConfig.getPassword());
	}
}
