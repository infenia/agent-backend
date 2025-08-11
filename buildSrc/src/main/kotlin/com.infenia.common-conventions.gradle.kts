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
    idea
    id("com.diffplug.spotless")
    id("org.sonarqube")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

// Note: Build cache and configuration cache must be configured at root project level
// Add these to your root build.gradle.kts or gradle.properties:
// - org.gradle.caching=true
// - org.gradle.configuration-cache=true

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    json {
        target("src/**/*.json")
        jackson()
    }
//    yaml {
//        target("src/**/*.yaml")
//        jackson()
//    }
    format("misc") {
        target("**/*.gradle", "**/*.md", "**/.gitignore")

        trimTrailingWhitespace()
        endWithNewline()
    }
}

sonarqube {
    properties {
        property("sonar.projectKey", "easymarry-backend")
        property("sonar.sources", "src/main/java")
        property("sonar.tests", "src/test/java")
        property("sonar.exclusions", "**/test/**,**/*Test.java,**/*Tests.java")
        property("sonar.coverage.jacoco.xmlReportPaths", "${layout.buildDirectory}/reports/jacoco/test/jacocoTestReport.xml")
    }
}

