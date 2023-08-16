package com.myRecipe.myRecipe_backend.domain.recipe.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecipeRequest {
    @Getter
    @NoArgsConstructor
    public static class RecipeCreateRequest {

        private String recipeName;
        private boolean publicityStatus;
        private Long recipeBookId;
        private Long userId;

        @Builder
        public RecipeCreateRequest(String recipeName, boolean publicityStatus, Long recipeBookId, Long userId) {
            this.recipeName = recipeName;
            this.publicityStatus = publicityStatus;
            this.recipeBookId = recipeBookId;
            this.userId = userId;
        }
    }
}
