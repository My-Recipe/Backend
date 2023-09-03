package com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class IngredientGroupRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class IngredientGroupCreateRequest {

        private String groupName;
        private String ingredientName;
        private Long ingredientAmount;
        private String ingredientUnit;

        @Builder
        public IngredientGroupCreateRequest(String groupName, String ingredientName,
                                            Long ingredientAmount, String ingredientUnit) {
            this.groupName = groupName;
            this.ingredientName = ingredientName;
            this.ingredientAmount = ingredientAmount;
            this.ingredientUnit = ingredientUnit;
        }
    }
}
