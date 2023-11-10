package com.friedNote.friedNote_backend.domain.user.domain.exception;

import com.friedNote.friedNote_backend.common.exception.Error;

public class UserNotFoundException extends UserException {

    public UserNotFoundException(Error error) {
        super(error);
    }
}
