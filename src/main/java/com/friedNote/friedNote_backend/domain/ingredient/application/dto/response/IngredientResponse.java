package com.friedNote.friedNote_backend.domain.ingredient.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class IngredientResponse {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class IngredientInfoResponse {

        private String ingredientName;
        private String ingredientAmount; //양 뒤에 단위까지

        @Builder
        public IngredientInfoResponse(String ingredientName, String ingredientAmount) {
            this.ingredientName = ingredientName;
            this.ingredientAmount = ingredientAmount;
        }
    }
}
