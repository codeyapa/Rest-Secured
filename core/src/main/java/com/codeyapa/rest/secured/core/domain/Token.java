package com.codeyapa.rest.secured.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.Instant;
import java.util.Set;

@Builder
@Value
@AllArgsConstructor
@EqualsAndHashCode
public class Token {
  String tokenId;
  String userId;
  String clientId;
  Instant validFrom;
  Instant expiresAt;
  Instant issuedAt;
  String issuer;
  String scope;
  Integer confidenceLevel;
  Set<String> audience;

  public boolean isFutureToken() {
    return !validFrom.isBefore(Instant.now());
  }

  public boolean isExpired() {
    return expiresAt.isBefore(Instant.now());
  }
}
