package com.shark.cache.exception;

import com.shark.util.util.StringUtil;

/**
 * @Author: Shark Chili
 * @Email: sharkchili.su@gmail.com
 * @Date: 2018/11/30 0030
 */
public abstract class CacheException extends RuntimeException{
	CacheException() {
		super();
	}

	CacheException(String message, Object... args) {
		super(StringUtil.format(message,args));
	}

	CacheException(String message, Throwable cause, Object... args) {
		super(StringUtil.format(message,args), cause);
	}

	CacheException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Object... args) {
		super(StringUtil.format(message,args), cause, enableSuppression, writableStackTrace);
	}
}