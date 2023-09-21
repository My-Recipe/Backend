package com.friedNote.friedNote_backend.common.security.jwt;

import com.friedNote.friedNote_backend.common.consts.ApplicationConst;
import com.friedNote.friedNote_backend.common.util.HeaderUtils;
import com.friedNote.friedNote_backend.common.consts.IgnoredPathConst;
import com.friedNote.friedNote_backend.common.util.SecurityUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * TODO : Authorities 설정 변경 필요 (현재는 ROLE_USER로 고정, enum으로 관리 필요)
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    //요청이 들어왔을때 토큰이 유효한지 검증
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (checkNotIgnoredPath(request.getRequestURI(), request.getMethod())) {
            final String header = HeaderUtils.getHeader(ApplicationConst.ACCESS_TOKEN_HEADER);
            final String accessToken = validateAuthorizationHeaderAndGetToken(header);
            validateAccessToken(accessToken);
            setAuthentication(accessToken);
        }
        filterChain.doFilter(request, response);
    }

    private boolean checkNotIgnoredPath(String requestURI, String method) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (String ignoredPath : IgnoredPathConst.IGNORED_PATHS) {
            if(antPathMatcher.match(ignoredPath, requestURI)&&method.equals("GET")) {
                return false;
            }
        }
        return true;
    }

    private String validateAuthorizationHeaderAndGetToken(final String header) {
        return SecurityUtils.validateHeaderAndGetToken(header);
    }

    private void validateAccessToken(final String accessToken) {
        jwtProvider.validateToken(accessToken);
    }

    private void setAuthentication(final String accessToken) {
        final String email = jwtProvider.extractEmail(accessToken);
        List<GrantedAuthority> grantedAuthorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_USER"));
        JwtAuthenticationToken authentication = new JwtAuthenticationToken(grantedAuthorities, email);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
