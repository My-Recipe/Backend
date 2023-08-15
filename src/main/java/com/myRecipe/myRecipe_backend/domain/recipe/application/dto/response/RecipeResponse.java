package com.myRecipe.myRecipe_backend.domain.recipe.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class RecipeResponse {

    @Getter
    public static class RecipeInfoResponse{
        private String dishName;

        @Builder
        public RecipeInfoResponse(String dishName) {
            this.dishName = dishName;
        }
    }
}
