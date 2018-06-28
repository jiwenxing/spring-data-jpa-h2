package com.jverson.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
public class JpaApplication {
	
private static Logger logger = LoggerFactory.getLogger(JpaApplication.class);
	
    public static void main( String[] args )
    {
    	SpringApplication.run(JpaApplication.class, args);
    	logger.info("Jpa应用服务启动完成!");
    }
    
}
