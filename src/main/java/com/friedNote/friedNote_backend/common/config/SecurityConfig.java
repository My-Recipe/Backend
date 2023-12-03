package com.friedNote.friedNote_backend.common.config;

import com.friedNote.friedNote_backend.common.security.auth.CustomOAuth2UserService;
import com.friedNote.friedNote_backend.common.security.auth.OAuth2SuccessHandler;
import com.friedNote.friedNote_backend.common.security.jwt.JwtAuthenticationEntryPoint;
import com.friedNote.friedNote_backend.common.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
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
        http.cors((cors) -> cors.configurationSource(corsConfigurationSource()));

        http.formLogin((formLogin) -> formLogin.disable());
        http.httpBasic((httpBasic) -> httpBasic.disable());

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationEntryPoint, JwtAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }


}