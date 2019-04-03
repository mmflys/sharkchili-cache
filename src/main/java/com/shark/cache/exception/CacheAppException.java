package com.shark.cache.exception;

/**
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public class CacheAppException extends CacheException{
	public CacheAppException() {
	}

	public CacheAppException(String message, Object... args) {
		super(message, args);
	}

	public CacheAppException(String message, Throwable cause, Object... args) {
		super(message, cause, args);
	}

	public CacheAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Object... args) {
		super(message, cause, enableSuppression, writableStackTrace, args);
	}
}
