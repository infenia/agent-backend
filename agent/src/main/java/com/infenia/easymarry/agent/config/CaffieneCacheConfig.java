package com.infenia.easymarry.agent.config;

import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CaffieneCacheConfig {
   @Bean
   public Caffeine caffeineConfig(){
        return Caffeine.newBuilder()
                .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .recordStats();
    }

    @Bean
    public CacheManager cacheManager(Caffeine<Object, Object> caffeineConfig) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("addresses");
        caffeineCacheManager.setCaffeine(caffeineConfig);
        return caffeineCacheManager;
    }
    }

