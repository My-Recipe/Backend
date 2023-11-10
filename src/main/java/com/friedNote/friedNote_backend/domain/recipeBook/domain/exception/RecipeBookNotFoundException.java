package com.friedNote.friedNote_backend.domain.recipeBook.domain.exception;

import com.friedNote.friedNote_backend.common.exception.Error;

public class RecipeBookNotFoundException extends RecipeBookException {
    public RecipeBookNotFoundException(Error error) {
        super(error);
    }
}
