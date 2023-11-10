package com.friedNote.friedNote_backend.domain.recipe.domain.exception;

import com.friedNote.friedNote_backend.common.exception.Error;

public class RecipeNotFoundException extends RecipeException {
    public RecipeNotFoundException(Error error) {
        super(error);
    }
}
