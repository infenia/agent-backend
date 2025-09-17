/*
 *
 * Copyright (c) 2025 Infenia Technologies Pvt. Ltd.
 *
 * This file is part of the EasyMarry Application.
 *
 * Licensed under the Infenia license; you may not use this file except
 * in compliance with the License. Unauthorized copying of this file,
 * via any medium is strictly prohibited.
 *
 * For more information, contact arun@infenia.com
 *
 */

package com.infenia.easymarry.agent.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infenia.easymarry.agent.property.PostgresqlDatabaseProperties;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryOptionsBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.List;

@Configuration(proxyBeanMethods = false)
@EnableR2dbcRepositories(
    basePackageClasses = {
    })
@EnableR2dbcAuditing
@EnableConfigurationProperties({PostgresqlDatabaseProperties.class})
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("PMD.ExcessiveImports")
public class DatabaseConfig extends AbstractR2dbcConfiguration {
  private final PostgresqlDatabaseProperties dbProps;
  private final ObjectMapper objectMapper;

  @Override
  @Bean
  @SuppressWarnings("NullableProblems")
  public ConnectionFactory connectionFactory() {
    log.info("AbstractR2dbcConfiguration - connectionFactory");
    // Use the customizer to build and configure the ConnectionFactoryOptions
    final var builder = ConnectionFactoryOptions.builder();
    connectionFactoryCustomizer().customize(builder);
    return ConnectionFactories.get(builder.build());
  }

  private ConnectionFactoryOptionsBuilderCustomizer connectionFactoryCustomizer() {
    log.info("Executing Bean method DatabaseConfig - connectionFactory");
    return builder ->
        builder
            .option(ConnectionFactoryOptions.DRIVER, this.dbProps.driver())
            .option(ConnectionFactoryOptions.PROTOCOL, this.dbProps.protocol())
            .option(ConnectionFactoryOptions.HOST, this.dbProps.host())
            .option(ConnectionFactoryOptions.PORT, this.dbProps.port())
            .option(ConnectionFactoryOptions.DATABASE, this.dbProps.database())
            .option(ConnectionFactoryOptions.USER, this.dbProps.user())
            .option(ConnectionFactoryOptions.PASSWORD, this.dbProps.password())
            // Disabling Schema selection as it is not support working with PGBouncer
            // .option(PostgresqlDatabaseProperties.DB_SCHEMA, this.dbProps.schema())
            .build();
  }

  @Bean("userFlyway")
  public Flyway flyway() {
    log.info("Executing Bean method DatabaseConfig - flyway");
    final var flywayConf = Flyway.configure();
	  final var flyway = flywayConf
        .dataSource(
            "jdbc:"
                + this.dbProps.protocol()
                + "://"
                + this.dbProps.host()
                + ":"
                + this.dbProps.port()
                + "/"
                + this.dbProps.database(),
            this.dbProps.user(),
            this.dbProps.password().toString())
        .defaultSchema("iuser")
        .schemas("report")
        .locations("classpath:db/migration/user")
        .baselineOnMigrate(true)
        .load();

	  flyway.migrate();

	  return flyway;
  }

}
