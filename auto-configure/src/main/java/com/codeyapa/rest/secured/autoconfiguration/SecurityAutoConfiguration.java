package com.codeyapa.rest.secured.autoconfiguration;

import com.codeyapa.rest.secured.core.properties.SecurityProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
    prefix = "rest.security",
    name = "enabled",
    havingValue = "true",
    matchIfMissing = true)
@ConditionalOnWebApplication
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityAutoConfiguration {}
