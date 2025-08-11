/*
 * Copyright (c) 2024 Infenia Private Limited. All rights reserved.
 */

plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("com.infenia.java-common-conventions")

    // Apply the application plugin to add support for building a CLI application in Java.
    application

//    id("org.graalvm.buildtools.native")
}


//graalvmNative {
//    testSupport = false
//}
