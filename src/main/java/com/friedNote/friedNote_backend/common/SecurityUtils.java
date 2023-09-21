package com.friedNote.friedNote_backend.common;

import com.friedNote.friedNote_backend.common.consts.ApplicationConst;
import com.friedNote.friedNote_backend.common.security.jwt.JwtAuthenticationToken;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.util.Optional;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class SecurityUtils {

    /**
     * TODO: 예외처리
     */
    public static String validateHeaderAndGetToken(final String headerValue) {
        return Optional.ofNullable(headerValue)
                .filter(header -> header.startsWith(ApplicationConst.JWT_AUTHORIZATION_TYPE))
                .filter(StringUtils::hasText)
                .map(header -> header.replace(ApplicationConst.JWT_AUTHORIZATION_TYPE, ""))
                .orElseThrow(() -> new RuntimeException("유효하지 않은 토큰입니다"));
    }

    public static String getUserEmail() {
        return (String) getAuthentication().getPrincipal();
    }

    private static JwtAuthenticationToken getAuthentication() {
        return (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }
}
