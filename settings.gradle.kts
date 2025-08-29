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

 pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}


// Configure all projects
rootProject.name = "agent-backend"

// Core modules
include(
    ":agent",
)


