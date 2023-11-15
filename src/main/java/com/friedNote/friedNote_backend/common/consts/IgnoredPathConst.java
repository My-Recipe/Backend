package com.friedNote.friedNote_backend.common.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IgnoredPathConst {

    public static final String[] IGNORED_PATHS = {
            "/oauth2/**",
            "/v3/api-docs/**",
            "/info",
            "/login/oauth2/**",
            "/reissue",
            "/favicon.ico",
            "/swagger-ui/index.html",
            "/swagger-ui.html",
            "/swagger-ui/**"
            };
}
