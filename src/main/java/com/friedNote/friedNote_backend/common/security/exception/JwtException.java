package com.friedNote.friedNote_backend.common.security.exception;

import com.friedNote.friedNote_backend.common.exception.BusinessException;
import com.friedNote.friedNote_backend.common.exception.Error;

public class JwtException extends BusinessException {
    public JwtException(Error error) {
        super(error);
    }
}
