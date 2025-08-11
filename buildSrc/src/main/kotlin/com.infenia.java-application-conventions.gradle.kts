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
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("com.infenia.java-common-conventions")

    // Apply the application plugin to add support for building a CLI application in Java.
    application

//    id("org.graalvm.buildtools.native")
}


//graalvmNative {
//    testSupport = false
//}
