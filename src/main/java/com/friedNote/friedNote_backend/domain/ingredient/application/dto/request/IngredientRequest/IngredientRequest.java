package com.friedNote.friedNote_backend.domain.ingredient.application.dto.request.IngredientRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class IngredientRequest {

    @Getter
    @NoArgsConstructor
    public static class IngredientCreateRequest {

        private String ingredientName;
        private Long ingredientAmount;
        private String ingredientUnit;

        public IngredientCreateRequest(String ingredientName, Long ingredientAmount, String ingredientUnit) {
            this.ingredientName = ingredientName;
            this.ingredientAmount = ingredientAmount;
            this.ingredientUnit = ingredientUnit;
        }
    }
}
