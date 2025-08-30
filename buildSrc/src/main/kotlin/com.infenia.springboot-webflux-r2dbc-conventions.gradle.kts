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

plugins {
    id("com.infenia.springboot-webflux-conventions")
}

dependencies {
    // Spring Data R2DBC
    //implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    
    // Database dependencies
//    implementation("org.flywaydb:flyway-core")
//    implementation("org.flywaydb:flyway-database-postgresql")
//    implementation("org.postgresql:postgresql")
//    implementation("org.postgresql:r2dbc-postgresql")
    
    // Testing database dependencies
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:r2dbc")
}
