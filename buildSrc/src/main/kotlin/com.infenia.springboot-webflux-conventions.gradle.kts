/*
 * Copyright (c) 2024 Infenia Private Limited. All rights reserved.
 */

plugins {
    id("com.infenia.springboot-application-conventions")
    id("org.asciidoctor.jvm.convert")
}

configurations {
    create("asciidoctorExtensions")
}

dependencies {
    // AsciiDoc extensions
    "asciidoctorExtensions"("org.springframework.restdocs:spring-restdocs-asciidoctor")
    
    // WebFlux dependencies
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    
    // WebFlux testing
    testImplementation("org.springframework.restdocs:spring-restdocs-webtestclient")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.rest-assured:spring-web-test-client")
}

//////////////////////////////////////
// Asciidoctor
//////////////////////////////////////

// Controller test task with optimized configuration
val controllerTest = tasks.register<Test>("controllerTest") {
    useJUnitPlatform {
        includeTags("ControllerTest")
    }
    controllerTestConfigurations()
    
    // For AsciiDoc snippets
    outputs.dir(project.extra["snippetsDir"]!!)
}

tasks.asciidoctor {
    configurations("asciidoctorExtensions")
    inputs.dir(project.extra["snippetsDir"]!!)
    dependsOn(controllerTest)
}

