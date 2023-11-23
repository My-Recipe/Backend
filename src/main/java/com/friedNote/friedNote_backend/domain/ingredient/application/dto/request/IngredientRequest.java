package com.friedNote.friedNote_backend.domain.ingredient.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class IngredientRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class IngredientCreateRequest {

        @Schema(description = "재료 이름", defaultValue = "ingredientName")
        private String ingredientName;
        @Schema(description = "재료 양", defaultValue = "ingredientAmount")
        private String ingredientAmount;
        @Schema(description = "재료 단위", defaultValue = "ingredientUnit")
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
        @Schema(description = "재료 이름", defaultValue = "ingredientName")
        private String ingredientName;
        @Schema(description = "재료 양", defaultValue = "ingredientAmount")
        private String ingredientAmount;
        @Schema(description = "재료 단위", defaultValue = "ingredientUnit")
        private String ingredientUnit;
        @Schema(description = "재료 그룹 식별자", defaultValue = "ingredientGroupId")
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
