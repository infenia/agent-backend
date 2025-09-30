package com.infenia.easymarry.agent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing(auditorAwareRef = "auditorProvider") // link to auditor bean
public class R2dbcConfig { }
