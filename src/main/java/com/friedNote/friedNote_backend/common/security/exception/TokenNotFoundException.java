package com.friedNote.friedNote_backend.common.security.exception;

import com.friedNote.friedNote_backend.common.exception.Error;

public class TokenNotFoundException extends JwtException {

    public TokenNotFoundException(Error error) {
        super(error);
    }
}
