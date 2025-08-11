/*
 * Copyright (c) 2024 Infenia Private Limited. All rights reserved.
 */

plugins {
    id("com.infenia.spring-library-conventions")
    id("org.springframework.boot")
}

tasks.named("bootJar") {
    enabled = false
}

dependencies {
    implementation("org.springframework:spring-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}