package com.myRecipe.myRecipe_backend.domain.recipeBook.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecipeBookRequest {

    @Getter
    @NoArgsConstructor
    public static class RecipeBookCreateRequest {

        private String title;
        private String subtitle;
    }

}
