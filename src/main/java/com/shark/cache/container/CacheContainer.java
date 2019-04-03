package com.shark.cache.container;

import com.shark.cache.cache.CacheAppType;
import com.shark.cache.cache.Pool;
import com.shark.cache.cache.PoolFactory;
import com.shark.cache.consts.CacheConfigConst;
import com.shark.container.Container;
import com.shark.container.constants.ContainerStatus;
import com.shark.container.util.ConfigUtil;
import com.shark.util.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Cache container
 * @Author: sharkchili
 * @Date: 2018/11/21 0021
 */
public abstract class CacheContainer implements Container {
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheContainer.class);

	/**resource pool*/
	private Pool pool;
	/**cache application type*/
	private CacheAppType type;
	/**cache container status*/
	private ContainerStatus containerStatus;

	public CacheContainer() {
		containerStatus = ContainerStatus.ZERO;
	}

	@Override
	public Container init() {
		LOGGER.info(this.getClass().getSimpleName() + " init ");
		initCacheAppType();
		initPool();
		//程序结束时调用钩子线程
		Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
		this.containerStatus = ContainerStatus.INITIALIZED;
		return this;
	}

	@Override
	public Container start() {
		LOGGER.info(this.getClass().getSimpleName() + " start ");
		this.containerStatus = ContainerStatus.RUNNING;
		return this;
	}

	@Override
	public Container stop() {
		LOGGER.info(this.getClass().getSimpleName() + " stop ");
		this.containerStatus = ContainerStatus.STOPPED;
		return this;
	}


	private void initCacheAppType(){
		Properties properties= FileUtil.readProperties("/"+ CacheConfigConst.CONFIG_FILE);
		this.type= (CacheAppType) ConfigUtil.getOrDefault(properties, CacheConfigConst.CACHE_APP_TYPE, CacheAppType.defaultTYpe());
	}

	private void initPool() {
		// read properties
		Properties properties= FileUtil.readProperties("/"+ CacheConfigConst.CONFIG_FILE);
		this.pool= PoolFactory.pool(properties, this.type);
	}

	/**
	 * Get a resource from pool
	 * @param <T> type of resource
	 * @return a resource from pool
	 */
	public synchronized  <T> T getResource(){
		return (T) this.pool.getCon();
	}
}
