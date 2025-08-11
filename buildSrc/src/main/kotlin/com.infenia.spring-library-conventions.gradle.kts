/*
 * Copyright (c) 2024 Infenia Private Limited. All rights reserved.
 */

plugins {
    id("com.infenia.java-library-conventions")
    id("io.spring.dependency-management")
}

dependencies {
    implementation("org.springframework:spring-core")
    implementation("org.springframework:spring-beans")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")

    testImplementation("org.springframework:spring-test")
}

