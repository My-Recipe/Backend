package com.friedNote.friedNote_backend.common.exception.dto;

import com.friedNote.friedNote_backend.common.exception.BusinessException;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int errorCode;

    private ErrorResponse(int errorCode) {
        this.errorCode = errorCode;
    }
    public static ErrorResponse from(BusinessException e) {
        return new ErrorResponse(e.getError().getErrorCode());
    }
}
