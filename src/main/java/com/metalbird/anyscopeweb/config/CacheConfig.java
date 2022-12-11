package com.metalbird.anyscopeweb.config;

import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@EnableCaching
@Configuration
@Slf4j
public class CacheConfig extends CachingConfigurerSupport {
    public static final String FAVORITE_CACHE = "favoriteCache";

    /**
     * 캐시매니저
     * - CACHE 에 사용되는 캐시를 설정한다.
     * - 3초단위 갱신
     */
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(String cacheName) {
                return new ConcurrentMapCache(cacheName, CacheBuilder.newBuilder()
                        .expireAfterWrite(3, TimeUnit.SECONDS)
                        .maximumSize(100)
                        .build().asMap(), false);
            }
        };

        cacheManager.setCacheNames(Arrays.asList(FAVORITE_CACHE));
        return cacheManager;
    }

}