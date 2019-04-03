package com.shark.cache;

import com.shark.cache.container.DefaultCacheContainer;
import com.shark.container.Container;
import com.shark.container.boot.Boot;
import com.shark.container.boot.Bootstrap;

/**
 * @Author: sharkchili
 * @Date: 2018/11/21 0021
 */
public class CacheBootStrap extends Bootstrap {

	@Override
	public Container provide() {
		return new DefaultCacheContainer();
	}

	/**
	 * Get a singleton
	 *
	 * @return a instance of CacheBootStrap
	 */
	public static CacheBootStrap get() {
		return (CacheBootStrap) InstanceHolder.BOOT;
	}

	/**
	 * Inner class for hold external class instance
	 */
	private static class InstanceHolder {

		private static final Boot BOOT=new CacheBootStrap();

		private void InvocationHandler() {
		}
	}

	public static void main(String[] args) {
		CacheBootStrap.get().launch();
	}
}
