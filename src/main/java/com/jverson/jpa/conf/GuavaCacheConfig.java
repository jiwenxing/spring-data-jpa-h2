package com.jverson.jpa.conf;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@Configuration
public class GuavaCacheConfig {

	/**
	 * GuavaCacheManager
	 */
	@Bean("cacheManager")
	public CacheManager GuavaCacheManager(){
		GuavaCacheManager cacheManager = new GuavaCacheManager();
		CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
//				.expireAfterWrite(6, TimeUnit.SECONDS)
				.expireAfterAccess(4, TimeUnit.SECONDS)
				.maximumSize(100); // 设置合适的缓存容量、这样超过容量以后,缓存就会按照 LRU 的方式回收缓存
		cacheManager.setCacheBuilder(cacheBuilder);
	    return cacheManager;
	}
	
}
