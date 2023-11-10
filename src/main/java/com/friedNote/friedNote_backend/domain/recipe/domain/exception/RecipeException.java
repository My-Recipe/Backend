package com.friedNote.friedNote_backend.domain.recipe.domain.exception;

import com.friedNote.friedNote_backend.common.exception.BusinessException;
import com.friedNote.friedNote_backend.common.exception.Error;

public class RecipeException extends BusinessException {
    public RecipeException(Error error) {
        super(error);
    }
}
