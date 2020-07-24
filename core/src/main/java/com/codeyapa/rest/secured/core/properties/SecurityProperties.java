package com.codeyapa.rest.secured.core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rest.security")
@Getter
@Setter
public class SecurityProperties {
  private boolean enabled = true;
}
