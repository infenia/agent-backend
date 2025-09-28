package com.infenia.easymarry.agent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import reactor.core.publisher.Mono;

@Configuration
public class AuditorAwareConfig {

    @Bean(name = "auditorProvider")
    public ReactiveAuditorAware<String> auditorAware() {
            return () -> Mono.just("system");
    }
}
