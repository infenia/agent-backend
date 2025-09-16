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
    id("com.infenia.springboot-webflux-r2dbc-conventions")

    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.flywaydb.flyway") version "9.22.3"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"


}

flyway {
    url = "jdbc:postgresql://localhost:5432/agent_backend"
    user = "postgres"
    password = "intern@2025"
    schemas = arrayOf("public")

}

springBoot {
    buildInfo {
        properties {
            artifact.set("infenia-easymarry-app")
            version.set("0.1.0")
            group.set("com.infenia.easymarry.user")
            name.set("User Application")
        }
    }
}

val keycloakVersion = "26.0.3"

dependencies {


        // Spring Boot WebFlux
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // R2DBC (Reactive Relational Database)
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

    // R2DBC PostgreSQL Driver
    implementation("org.postgresql:r2dbc-postgresql:1.0.5.RELEASE")

    // JDBC Driver (needed by Flyway/Liquibase migrations, not by R2DBC itself)
        implementation("org.postgresql:postgresql:42.7.4")

        // Lombok
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        testCompileOnly("org.projectlombok:lombok")
        testAndDevelopmentOnly("org.projectlombok:lombok")

        // Testing
        testImplementation( "org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.projectreactor:reactor-test")




    implementation("org.springframework.boot:spring-boot-starter-webflux") // Only if your app uses WebFlux
    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql:42.7.4")

}

application {
    // Define the main class for the application.
    mainClass.set("com.infenia.easymarry.agent.AgentApplication")
}


pmd {
    isConsoleOutput = true
    toolVersion = "7.4.0"
    ruleSetFiles("pmd-user-ruleset.xml")
}
