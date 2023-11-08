package com.friedNote.friedNote_backend.domain.user.domain.exception;

import com.friedNote.friedNote_backend.common.exception.BusinessException;
import com.friedNote.friedNote_backend.common.exception.Error;

public class UserException extends BusinessException {

        public UserException(Error error) {
            super(error);
        }
}
