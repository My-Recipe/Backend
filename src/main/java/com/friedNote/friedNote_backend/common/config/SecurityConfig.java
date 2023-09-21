package com.friedNote.friedNote_backend.common.config;

import com.friedNote.friedNote_backend.common.security.auth.CustomOAuth2UserService;
import com.friedNote.friedNote_backend.common.security.auth.OAuth2SuccessHandler;
import com.friedNote.friedNote_backend.common.security.jwt.JwtAuthenticationEntryPoint;
import com.friedNote.friedNote_backend.common.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2Login(
                oauth2Login -> oauth2Login
                        .successHandler(oAuth2SuccessHandler)
                        .userInfoEndpoint((userInfoEndpoint -> userInfoEndpoint.userService(customOAuth2UserService))
                        )
        );
        http.sessionManagement((sessionManagement) ->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeRequests().anyRequest().permitAll();
        http.csrf((csrf) -> csrf.disable());
        //http.cors();

        http.formLogin((formLogin) -> formLogin.disable());
        http.httpBasic((httpBasic) -> httpBasic.disable());

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationEntryPoint, JwtAuthenticationFilter.class);
        return http.build();
    }


}