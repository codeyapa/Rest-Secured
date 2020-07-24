package com.codeyapa.rest.secured.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueTokenResponse {
  @JsonProperty("access_token")
  String accessToken;

  @JsonProperty("refresh_token")
  String refreshToken;

  @JsonProperty("expires_in")
  Integer expiresIn;

  @JsonProperty("token_type")
  String tokenType;

  @JsonProperty("scope")
  String scope;

  @JsonProperty("confidence_level")
  Integer confidenceLevel;
}
