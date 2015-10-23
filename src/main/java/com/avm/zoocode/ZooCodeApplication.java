package com.avm.zoocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
/**
 * Spring boot entry point.
 * @author amodm1
 *
 */
@SpringBootApplication
@EnableCaching
public class ZooCodeApplication {

	@Bean
    public CacheManager cacheManager() {
		//TODO set for user domain
        return new ConcurrentMapCacheManager("users");
    }
	
	//TODO Logging
    public static void main(String[] args) {
        SpringApplication.run(ZooCodeApplication.class, args);
    }
}
