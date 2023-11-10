package com.friedNote.friedNote_backend.domain.recipeBook.domain.exception;

import com.friedNote.friedNote_backend.common.exception.BusinessException;
import com.friedNote.friedNote_backend.common.exception.Error;


public class RecipeBookException extends BusinessException {
    public RecipeBookException(Error error) {
        super(error);
    }
}
