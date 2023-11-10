package com.friedNote.friedNote_backend.common.security.exception;

import com.friedNote.friedNote_backend.common.exception.Error;

public class ExpiredTokenException extends JwtException {

    public ExpiredTokenException(Error error) {
        super(error);
    }
}
