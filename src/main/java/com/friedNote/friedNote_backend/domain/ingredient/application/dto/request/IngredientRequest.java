package com.friedNote.friedNote_backend.domain.ingredient.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class IngredientRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class IngredientCreateRequest {

        private String ingredientName;
        private String ingredientAmount;
        private String ingredientUnit;

        @Builder
        public IngredientCreateRequest(String ingredientName, String ingredientAmount, String ingredientUnit) {
            this.ingredientName = ingredientName;
            this.ingredientAmount = ingredientAmount;
            this.ingredientUnit = ingredientUnit;
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class IngredientUpdateRequest {
        private String ingredientName;
        private String ingredientAmount;
        private String ingredientUnit;
        private Long ingredientGroupId;

        @Builder
        public IngredientUpdateRequest(String ingredientName, String ingredientAmount, String ingredientUnit, Long ingredientGroupId) {
            this.ingredientName = ingredientName;
            this.ingredientAmount = ingredientAmount;
            this.ingredientUnit = ingredientUnit;
            this.ingredientGroupId = ingredientGroupId;
        }
    }
}
