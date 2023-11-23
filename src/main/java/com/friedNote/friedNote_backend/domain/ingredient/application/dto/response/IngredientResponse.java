package com.friedNote.friedNote_backend.domain.ingredient.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class IngredientResponse {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class IngredientInfoResponse {
        @Schema(description = "재료 이름", defaultValue = "ingredientName")
        private String ingredientName;
        @Schema(description = "재료 양", defaultValue = "ingredientAmount")
        private String ingredientAmount; //양 뒤에 단위까지

        @Builder
        public IngredientInfoResponse(String ingredientName, String ingredientAmount) {
            this.ingredientName = ingredientName;
            this.ingredientAmount = ingredientAmount;
        }
    }
}
