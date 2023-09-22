package com.friedNote.friedNote_backend.common.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "auth.jwt")
public class JwtProperties {

    private final String secret;
    private final long accessTokenPeriod;
    private final long refreshTokenPeriod;

}
