package com.codeyapa.rest.secured.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static java.time.Instant.ofEpochSecond;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class ValidateTokenResponse {
  @JsonProperty("active")
  private boolean active;

  @JsonProperty("jti")
  private String tokenId;

  @JsonProperty("iss")
  private String issuer;

  @JsonProperty("sub")
  private String subject;

  @JsonProperty("aud")
  private Collection<String> audience;

  @JsonProperty("iat")
  private Long issuedAt;

  @JsonProperty("nbf")
  private Long notBefore;

  @JsonProperty("exp")
  private Long expirationTime;

  @JsonProperty("scope")
  private String scope;

  @JsonProperty("confidence_level")
  private Integer confidenceLevel;

  @JsonProperty("client_id")
  private String clientId;

  @JsonProperty("token_type")
  private String tokenType;

  public Optional<Token> toToken() {
    if (!active || subject == null) {
      return Optional.empty();
    }
    try {
      return Optional.of(
          Token.builder()
              .userId(subject)
              .clientId(clientId)
              .issuedAt(ofEpochSecond(issuedAt))
              .expiresAt(ofEpochSecond(expirationTime))
              .validFrom(ofEpochSecond(notBefore))
              .confidenceLevel(confidenceLevel)
              .audience(audience == null ? Collections.emptySet() : new HashSet<>(audience))
              .scope(scope)
              .tokenId(tokenId)
              .build());
    } catch (IllegalArgumentException | NullPointerException e) {
      log.error("The token could not be parsed as a valid JWT.", e);
      return Optional.empty();
    }
  }
}
