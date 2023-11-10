package com.friedNote.friedNote_backend.common.exception.handler;

import com.friedNote.friedNote_backend.common.exception.BusinessException;
import com.friedNote.friedNote_backend.common.exception.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleJwtException(BusinessException e) {
        final ErrorResponse errorResponse = ErrorResponse.from(e);
        log.info("errorResponse: {} {}", e.getError().getErrorCode(),e.getError().getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
