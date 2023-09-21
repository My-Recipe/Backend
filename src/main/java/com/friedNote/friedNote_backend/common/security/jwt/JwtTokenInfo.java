package com.friedNote.friedNote_backend.common.security.jwt;

import lombok.Getter;

@Getter
public class JwtTokenInfo {

    private final String accessToken;
    private final String refreshToken;

    public JwtTokenInfo(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

}