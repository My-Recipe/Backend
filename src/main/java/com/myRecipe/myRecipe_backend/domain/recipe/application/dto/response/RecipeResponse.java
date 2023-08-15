package com.myRecipe.myRecipe_backend.domain.recipe.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class RecipeResponse {

    @Getter
    public static class RecipeInfoResponse{
        private String recipeName;

        @Builder
        public RecipeInfoResponse(String recipeName) {
            this.recipeName = recipeName;
        }
    }
}
