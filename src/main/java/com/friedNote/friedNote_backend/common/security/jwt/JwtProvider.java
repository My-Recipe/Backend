package com.friedNote.friedNote_backend.common.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import static com.friedNote.friedNote_backend.common.consts.ApplicationConst.*;

/**
 * Jwt 토큰 생성, 토큰 복호화 및 정보 추출, 토큰 유효성 검증
 * 토큰 재발급
 */
@Slf4j
@Component
@NoArgsConstructor
public class JwtProvider {

    @Value("${auth.jwt.secret}")
    private String key;

    @Value("${auth.jwt.access-token-period}")
    private String accessTokenPeriod;

    @Value("${auth.jwt.refresh-token-period}")
    private String refreshTokenPeriod;

    private Key getSecretKey() {
        return Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }

    //유저정보(email)을 통해 Token 생성
    public String generateAccessToken(String email, Date now) {
        String accessToken = Jwts.builder()
                .setIssuedAt(now)
                .signWith(getSecretKey())
                .setExpiration(new Date(now.getTime() + accessTokenPeriod))
                .setSubject(email)
                .claim(TOKEN_TYPE, ACCESS_TOKEN)
                .compact();
        return accessToken;
    }

    /**
     * refreshToken은 서버에 저장해두어야함
     */
    public String generateRefreshToken(String email, Date now) {
        String refreshToken = Jwts.builder()
                .setIssuedAt(now)
                .signWith(getSecretKey())
                .setExpiration(new Date(now.getTime() + refreshTokenPeriod))
                .setSubject(email)
                .claim(TOKEN_TYPE, REFRESH_TOKEN) //key-value로 데이터 추가
                .compact();
        return refreshToken;
    }

    /**
     * TODO: 예외처리
     * Token 유효성 검증
     */
    public void validateToken(String token) {
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build();
        try {
            jwtParser.parse(token); //returns the resulting unsigned plaintext JWT instance.
        } catch (MalformedJwtException | SignatureException | IllegalArgumentException e){
            throw new RuntimeException("유효하지 않은 토큰입니다");
        } catch (ExpiredJwtException e){
            throw new RuntimeException("만료된 토큰입니다");
        }
    }

    public String extractEmail(String token){
        String email = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return email;
    }

    /**
     * TODO: 토큰 재발급
     */
//    public String reIssue(String refreshToken){
//        String email = validateRefreshToken(refreshToken);
//        return generateAccessToken(email);
//    }
//
//    public String validateRefreshToken(String refreshToken) {
//        validateToken(refreshToken);
//        final String email = extractEmail(refreshToken);
//        final String storedRefreshToken = getRefreshToken(email);
//        if(!Objects.equals(refreshToken, storedRefreshToken)){
//            throw new InvalidTokenException(Error.INVALID_TOKEN);
//        }
//        return email;
//    }
}
