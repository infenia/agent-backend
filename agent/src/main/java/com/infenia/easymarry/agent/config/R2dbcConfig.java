package com.infenia.easymarry.agent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.dialect.R2dbcDialect;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableR2dbcAuditing(auditorAwareRef = "auditorProvider") // link to auditor bean
public class R2dbcConfig {
    @Bean
    public R2dbcCustomConversions r2dbcCustomConversions() {
        List<Object> converters = new ArrayList<>();
        converters.add(new FamilyDetailsToJsonConverter());
        converters.add(new JsonToFamilyDetailsConverter());

        R2dbcDialect dialect = PostgresDialect.INSTANCE;
        return new R2dbcCustomConversions(
                CustomConversions.StoreConversions.of(dialect.getSimpleTypeHolder()),
                converters
        );
    }


}