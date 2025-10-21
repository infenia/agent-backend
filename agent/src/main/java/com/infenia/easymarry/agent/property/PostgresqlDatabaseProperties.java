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

package com.infenia.easymarry.agent.property;

import io.r2dbc.spi.Option;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** This Record holds the property values for Postgresql connection */
@ConfigurationProperties(prefix = "db.postgresql.user")
public record PostgresqlDatabaseProperties(
    String driver,
    String host,
    String database,
    String schema,
    Integer port,
    String user,
    CharSequence password,
    String protocol,
    Boolean ssl,
    Long connectTimeout,
    Long statementTimeout,
    String validationQuery,
    Long maxIdleTime,
    Long maxLifeTime,
    Long maxAcquireTime,
    Long maxCreateConnectionTime) {
  public static final Option<String> DB_SCHEMA = Option.valueOf("schema");
}
