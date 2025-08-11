/*
 * Copyright (c) 2024-2025 Infenia Private Limited. All rights reserved.
 */

package com.infenia.easymarry.user;

import com.infenia.easymarry.user.common.config.NativeRuntimeHints;
import com.infenia.util.annotation.ExcludeFromJacocoGeneratedReport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import reactor.core.publisher.Hooks;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@Slf4j
@EnableRetry
@ExcludeFromJacocoGeneratedReport
@ImportRuntimeHints(NativeRuntimeHints.class)
@SuppressWarnings("PMD.UseUtilityClass")
public class UserApplication {

  public static void main(final String[] args) {
    log.info("Starting User Application");
    Hooks.enableAutomaticContextPropagation();
    new SpringApplicationBuilder().sources(UserApplication.class).run(args);
  }
}
