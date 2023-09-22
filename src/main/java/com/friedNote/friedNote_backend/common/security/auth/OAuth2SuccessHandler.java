package com.friedNote.friedNote_backend.common.security.auth;

import com.friedNote.friedNote_backend.common.security.jwt.JwtProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static com.friedNote.friedNote_backend.common.consts.ApplicationConst.ACCESS_TOKEN_HEADER;
import static com.friedNote.friedNote_backend.common.consts.ApplicationConst.REFRESH_TOKEN_HEADER;


/**
 * 로그인 성공했을때 처리하는 핸들러, 토큰 정보에 이메일만 담겨있음
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Value("${frontend.url}")
    private String FRONTEND_URL;
    private final JwtProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2SuccessHandler");
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        log.info("OAuth2SuccessHandler : {}", oAuth2User);
        TokenInfo tokenInfo = generateToken(oAuth2User.getAttribute("email")); //토큰 생성
        response.sendRedirect(UriComponentsBuilder.fromUriString(FRONTEND_URL)
                .queryParam(ACCESS_TOKEN_HEADER, tokenInfo.getAccessToken())
                .queryParam(REFRESH_TOKEN_HEADER, tokenInfo.getRefreshToken()).build()
                .encode(StandardCharsets.UTF_8)
                .toUriString());
    }


    private TokenInfo generateToken(String email) {
        final Date now = new Date();
        String accessToken = jwtProvider.generateAccessToken(email, now);
        String refreshToken = jwtProvider.generateRefreshToken(email, now);

        return new TokenInfo(accessToken, refreshToken);
    }


    @Getter
    private static class TokenInfo {
        private final String accessToken;
        private final String refreshToken;

        public TokenInfo(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }

    }
}