package com.myRecipe.myRecipe_backend.domain.recipe.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecipeRequest {
    @Getter
    @NoArgsConstructor
    public static class RecipeCreateRequest {

        private String dishName;
        private boolean publicityStatus;

        @Builder
        public RecipeCreateRequest(String dishName, boolean publicityStatus) {
            this.dishName = dishName;
            this.publicityStatus = publicityStatus;
        }
    }
}
