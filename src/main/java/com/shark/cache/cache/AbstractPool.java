package com.shark.cache.cache;

/**
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public abstract class AbstractPool<P,T> implements Pool<P,T> {
	protected P appPool;

	public AbstractPool(Config config) {
		setAppPool(config);
	}

	/**
	 * Set app pool according to config
	 * @param config config
	 */
	public abstract void setAppPool(Config config);

	/**
	 * Get a resource from pool.
	 * @return a resource
	 */
	public abstract T getMyResource();

	@Override
	public T getCon() {
		T t=getMyResource();
		auth(t);
		return t;
	}

	@Override
	public P getAppPool() {
		return this.appPool;
	}
}
