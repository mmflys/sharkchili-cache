package com.shark.cache.exception;

/**
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/12/1 0001
 */
public class ConfigException extends CacheException{
	public ConfigException() {
		super();
	}

	public ConfigException(String message, Object... args) {
		super(message, args);
	}

	public ConfigException(String message, Throwable cause, Object... args) {
		super(message, cause, args);
	}

	public ConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Object... args) {
		super(message, cause, enableSuppression, writableStackTrace, args);
	}
}
