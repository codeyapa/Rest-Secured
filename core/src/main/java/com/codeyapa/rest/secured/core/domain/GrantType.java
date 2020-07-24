package com.codeyapa.rest.secured.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum GrantType {
  @JsonProperty("password")
  PASSWORD,

  @JsonProperty("refresh_token")
  REFRESH_TOKEN,

  @JsonProperty("client_credentials")
  CLIENT_CREDENTIALS
}
