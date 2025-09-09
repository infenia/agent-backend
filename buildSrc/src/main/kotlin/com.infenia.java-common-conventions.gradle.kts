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
    java
    pmd
    jacoco
    id("com.infenia.common-conventions")
    id("io.freefair.lombok")
    id("com.github.spotbugs")
    id("org.owasp.dependencycheck")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

val apacheCommonsTextVersion = "1.10.0"
val mapstructVersion = "1.6.3"
val dataFakerVersion = "2.0.1"
val jacksonDataFormatYaml = "2.19.0"

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.apache.commons:commons-text:${apacheCommonsTextVersion}")
    }
    
    // Core utilities
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${jacksonDataFormatYaml}")
    
    // Annotation processors
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
    
    // Testing dependencies
    testImplementation("net.datafaker:datafaker:${dataFakerVersion}")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

spotless {
    java {
        importOrder()
        cleanthat()
        googleJavaFormat()
        formatAnnotations()
        targetExclude("build/generated-test-sources/**/*.java")
    }
}

tasks.compileJava {
    // Enable compilation in a separate daemon process with optimizations
    options.isFork = true
    options.isIncremental = true
    
    // JVM performance optimizations for compilation
    options.forkOptions.jvmArgs?.addAll(listOf(
        "-Xms512m",
        "-Xmx2g",
        "-XX:+UseG1GC",
        "-XX:+UseStringDeduplication",
        "-XX:MaxGCPauseMillis=100"
    ))
    
    // Enable parallel compilation
    options.forkOptions.memoryMaximumSize = "2g"
}

//For Ascii doc
extra["snippetsDir"] = file("build/generated-snippets")

// Mockito agent configuration
val mockitoAgent: Configuration = configurations.create("mockitoAgent")
dependencies {
    mockitoAgent("org.mockito:mockito-core") { isTransitive = false }
}

// Enhanced test configurations using optimized TestExtensions
tasks.test {
    jvmArgs("-javaagent:${mockitoAgent.asPath}")
    
    useJUnitPlatform {
        includeTags("UnitTest")
        excludeTags("IntegrationTest")
    }
    
    serviceTestConfigurations()
    finalizedBy(tasks.jacocoTestReport)
    
    outputs.dir(project.extra["snippetsDir"]!!)
}

// Domain-specific test tasks with optimized configurations
tasks.register<Test>("entityDTOMapperTest") {
    useJUnitPlatform {
        includeTags("EntityDTOMapperTest")
    }
    mapperTestConfigurations()
}

tasks.register<Test>("serviceTest") {
    useJUnitPlatform {
        includeTags("ServiceTest")
    }
    serviceTestConfigurations()
}

// Integration test with optimized configuration
val integrationTest by tasks.registering(Test::class) {
    group = "verification"
    useJUnitPlatform {
        includeTags("IntegrationTest")
    }
    integrationTestConfigurations()
}

// Jacoco with realistic coverage requirements
tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            element = "CLASS"
            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = 1.0.toBigDecimal()
            }
        }
        rule {
            element = "CLASS"
            limit {
                counter = "BRANCH"
                value = "COVEREDRATIO"
                minimum = 1.0.toBigDecimal()
            }
        }
        rule {
            limit {
                counter = "CLASS"
                value = "COVEREDRATIO"
                minimum = 1.0.toBigDecimal()
            }
        }
        rule {
            element = "CLASS"
            limit {
                counter = "INSTRUCTION"
                value = "COVEREDRATIO"
                minimum = 1.0.toBigDecimal()
            }
        }
        rule {
            element = "CLASS"
            limit {
                counter = "METHOD"
                value = "COVEREDRATIO"
                minimum = 1.0.toBigDecimal()
            }
        }
    }
}

tasks.check {
    dependsOn(integrationTest)
    dependsOn(tasks.jacocoTestCoverageVerification)
}

// PMD Configuration
pmd {
    isConsoleOutput = true
    threads.set(Runtime.getRuntime().availableProcessors().div(2))
    incrementalAnalysis.set(true)
    toolVersion = "7.0.0-rc4" // TODO: Move to version catalog when buildSrc supports it
}

// SpotBugs Configuration
spotbugs {
    reportsDir = layout.buildDirectory.dir("spotbugs")
    excludeFilter = file("spotbugs-exclude-filter.xml")
}
