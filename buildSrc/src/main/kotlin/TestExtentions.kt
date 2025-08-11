/*
 * Copyright (c) 2024-2025 Infenia Private Limited. All rights reserved.
 */

import org.gradle.api.tasks.testing.Test

/**
 * Enhanced test configuration extensions for different test types.
 * Provides optimized settings based on test characteristics and requirements.
 */

// Legacy method for backward compatibility
fun Test.testConfigurations(maxHeap: String) {
    group = "verification"
    forkEvery = 1000
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
    maxHeapSize = maxHeap

    reports.html.required.set(false)
    reports.junitXml.required.set(false)
}

/**
 * Optimized configuration for service-layer tests
 * - Lower memory requirements
 * - Higher parallelism for faster execution
 */
fun Test.serviceTestConfigurations() {
    group = "verification"
    maxHeapSize = "1G"
    forkEvery = 1000
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
    
    // Service tests can run with minimal JVM options
    jvmArgs("-Xms512m", "-XX:+UseG1GC", "-XX:+UseStringDeduplication")
    
    reports.html.required.set(false)
    reports.junitXml.required.set(false)
}

/**
 * Configuration for controller/web-layer tests
 * - Higher memory for Spring WebFlux context
 * - REST Docs generation support
 */
fun Test.controllerTestConfigurations() {
    group = "verification"
    maxHeapSize = "2G"
    forkEvery = 500  // Lower fork frequency for web tests
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 3).coerceAtLeast(1)
    
    // Web tests need more memory and faster GC
    jvmArgs(
        "-Xms1G",
        "-XX:+UseG1GC",
        "-XX:+UseStringDeduplication",
        "-XX:MaxGCPauseMillis=100"
    )
    
    reports.html.required.set(false)
    reports.junitXml.required.set(false)
}

/**
 * Configuration for integration tests
 * - Maximum resources allocation
 * - Single fork for database consistency
 * - Testcontainers support
 */
fun Test.integrationTestConfigurations() {
    group = "verification"
    maxHeapSize = "2G"
    forkEvery = 0  // No forking for integration tests
    maxParallelForks = 1  // Single thread for database consistency
    
    // Integration tests need maximum resources
    jvmArgs(
        "-Xms1G",
        "-XX:+UseG1GC",
        "-XX:+UseStringDeduplication",
        "-XX:MaxGCPauseMillis=200",
        "-Dtestcontainers.reuse.enable=true"  // Reuse containers
    )
    
    // Enable more detailed logging for integration issues
    systemProperty("reactor.netty.http.server.accessLogEnabled", "true")
    systemProperty("logging.level.org.springframework.r2dbc", "DEBUG")
    
    reports.html.required.set(false)
    reports.junitXml.required.set(false)
}

/**
 * Lightweight configuration for entity/DTO mapper tests
 * - Minimal resources
 * - High parallelism
 */
fun Test.mapperTestConfigurations() {
    group = "verification"
    maxHeapSize = "512M"
    forkEvery = 2000
    maxParallelForks = Runtime.getRuntime().availableProcessors().coerceAtLeast(2)
    
    // Minimal JVM options for simple mapper tests
    jvmArgs("-Xms256m", "-XX:+UseSerialGC")
    
    reports.html.required.set(false)
    reports.junitXml.required.set(false)
}