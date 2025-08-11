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
