package com.shark.cache.cache;

/**
 * Pool
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public interface Pool<P,T> {

	/**
	 * Get the application pool
	 * @return a application pool,eg: {@link redis.clients.jedis.JedisPool}
	 */
	public P getAppPool();

	/**
	 * Get a connection from the pool
	 * @return a connection to cache app
	 */
	public T getCon();

	/**
	 * Auth to a resource
	 * @param t resource
	 */
	public void auth(T t);
}
