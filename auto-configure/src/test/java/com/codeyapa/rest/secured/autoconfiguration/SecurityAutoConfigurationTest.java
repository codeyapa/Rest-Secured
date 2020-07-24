package com.codeyapa.rest.secured.autoconfiguration;

import org.junit.Test;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.autoconfigure.AutoConfigurations.of;

public class SecurityAutoConfigurationTest {
  private WebApplicationContextRunner applicationContextRunner;

  @Test
  public void shouldCreateAutoConfiguredBeanIfStarterIsEnabled() {
    applicationContextRunner =
        new WebApplicationContextRunner()
            .withPropertyValues(properties(true))
            .withConfiguration(of(SecurityAutoConfiguration.class));

    this.applicationContextRunner.run(
        context -> {
        });
  }

  @Test
  public void shouldNotCreateAutoConfiguredBeanIfStarterIsNotEnabled() {
    applicationContextRunner =
        new WebApplicationContextRunner()
            .withPropertyValues(properties(false))
            .withConfiguration(of(SecurityAutoConfiguration.class));

    this.applicationContextRunner.run(
        context -> {
        });
  }

  private String[] properties(boolean enabled) {
    return new String[] {
      String.format("rest.security.enabled=%b", enabled),
    };
  }
}
