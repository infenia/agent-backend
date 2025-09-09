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

import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

/*
 * Copyright (c) 2024-2025 Infenia Private Limited. All rights reserved.
 */

plugins {
    id("com.infenia.spring-application-conventions")
    id("org.springframework.boot")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


// Spring Cloud version managed through version catalog
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2024.0.0")
    }
}

val logstashLogbackEncoderVersion = "8.1"

dependencies {
    // Core Spring Boot starters
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    
    // Observability
    implementation("io.opentelemetry:opentelemetry-exporter-otlp")
    implementation("io.micrometer:micrometer-tracing-bridge-otel")
    implementation("net.logstash.logback:logstash-logback-encoder:${logstashLogbackEncoderVersion}")
    
    // Utilities
    implementation("org.springframework.retry:spring-retry")
    implementation("com.jayway.jsonpath:json-path:2.8.0") // TODO: We may need to remove this


    //Using Loki appender since OpenTelemetry log export is not working
//    implementation("com.github.loki4j:loki-logback-appender:1.4.2")

    runtimeOnly("org.springframework.boot:spring-boot-starter-aop")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
}

tasks.named<BootBuildImage>("bootBuildImage") {
    imageName.set("localhost:32000/${project.name}") //TODO: This should be based on the environment
    publish.set(true)
    buildCache {
        volume {
            name.set("cache-${rootProject.name}.build")
        }
    }
    launchCache {
        volume {
            name.set("cache-${rootProject.name}.launch")
        }
    }
}

