package com.codeyapa.rest.secured.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class IssueTokenRequest {
  @JsonProperty("client_id")
  private String clientId;

  @JsonProperty("grant_type")
  private GrantType grantType;

  private String scope;
  private String username;
  private String password;
  private int confidenceLevel;

  @JsonProperty("refresh_token")
  private String refreshToken;

  public IssueTokenRequest(String clientId, String username, String password, String scope) {
    this.clientId = clientId;
    this.grantType = GrantType.PASSWORD;

    this.username = username;
    this.password = password;
    this.scope = scope;
  }

  public IssueTokenRequest(String clientId, String refreshToken) {
    this.clientId = clientId;
    this.grantType = GrantType.REFRESH_TOKEN;
    this.refreshToken = refreshToken;
  }

  public IssueTokenRequest(String clientId, String scope, int confidenceLevel) {
    this.clientId = clientId;
    this.scope = scope;
    this.confidenceLevel = confidenceLevel;
    this.grantType = GrantType.CLIENT_CREDENTIALS;
  }
}
