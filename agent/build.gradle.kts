/*
 * Copyright (c) 2024-2025 Infenia Private Limited. All rights reserved.
 */

plugins {
    id("com.infenia.springboot-webflux-r2dbc-conventions")
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
