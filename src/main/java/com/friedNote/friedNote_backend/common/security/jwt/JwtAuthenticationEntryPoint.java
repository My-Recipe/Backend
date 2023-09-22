package com.friedNote.friedNote_backend.common.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    /**
     * TODO: 예외처리
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            filterChain.doFilter(request, response);
        } catch (RuntimeException e){
            //예외처리
        }
    }

   // private void setErrorCode(HttpServletResponse response, JwtException e) throws IOException {
        //ErrorResponse errorResponse = ErrorResponse.from(e);
        //response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        //response.setContentType("application/json");
        //response.setCharacterEncoding("UTF-8");
        //response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    //}
}
