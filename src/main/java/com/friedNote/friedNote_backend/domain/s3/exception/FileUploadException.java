package com.friedNote.friedNote_backend.domain.s3.exception;

import com.friedNote.friedNote_backend.common.exception.Error;
import com.friedNote.friedNote_backend.common.exception.BusinessException;

public class FileUploadException extends BusinessException {
    public FileUploadException(Error error) {
        super(error);
    }
}
