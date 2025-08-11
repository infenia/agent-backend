/*
 * Copyright (c) 2024 Infenia Private Limited. All rights reserved.
 */

plugins {
    id("com.infenia.springboot-webflux-conventions")
}

dependencies {
    // Spring Data R2DBC
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    
    // Database dependencies
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.postgresql:postgresql")
    implementation("org.postgresql:r2dbc-postgresql")
    
    // Testing database dependencies
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:r2dbc")
}
