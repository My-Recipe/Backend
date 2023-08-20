package com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class IngredientGroupRequest {

    @Getter
    @NoArgsConstructor
    public static class IngredientGroupCreateRequest {
        private String ingredientName;
        private Long ingredientAmount;
        private String ingredientUnit;
        private Long recipeId;

        @Builder
        public IngredientGroupCreateRequest(String ingredientName, Long ingredientAmount, String ingredientUnit, Long recipeId) {
            this.ingredientName = ingredientName;
            this.ingredientAmount = ingredientAmount;
            this.ingredientUnit = ingredientUnit;
            this.recipeId = recipeId;
        }
    }
}
