package com.jverson.jpa.conf;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@Configuration
public class GuavaCacheConfig {

	@Bean
	public CacheManager cacheManager(){
		GuavaCacheManager cacheManager = new GuavaCacheManager();
		CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
				.maximumSize(100)
				.expireAfterAccess(6, TimeUnit.SECONDS);
		cacheManager.setCacheBuilder(cacheBuilder);
	    return cacheManager;
	}
	
}
