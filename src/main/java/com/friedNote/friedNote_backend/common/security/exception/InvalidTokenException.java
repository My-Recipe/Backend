package com.friedNote.friedNote_backend.common.security.exception;

import com.friedNote.friedNote_backend.common.exception.Error;

public class InvalidTokenException extends JwtException {

        public InvalidTokenException(Error error) {
            super(error);
        }
}
