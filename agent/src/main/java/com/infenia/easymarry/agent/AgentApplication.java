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

package com.infenia.easymarry.agent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import reactor.core.publisher.Hooks;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@Slf4j
@EnableRetry
@EnableCaching
@SuppressWarnings("PMD.UseUtilityClass")
public class AgentApplication {

  public static void main(final String[] args) {
    log.info("Starting User Application");
    Hooks.enableAutomaticContextPropagation();
    new SpringApplicationBuilder().sources(AgentApplication.class).run(args);
  }
}
