package com.codeyapa.rest.secured.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rest.security")
public class SecurityProperties {
  private boolean enabled = true;
}
