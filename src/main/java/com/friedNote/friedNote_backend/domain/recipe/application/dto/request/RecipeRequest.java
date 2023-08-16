package com.friedNote.friedNote_backend.domain.recipe.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecipeRequest {
    @Getter
    @NoArgsConstructor
    public static class RecipeCreateRequest {

        private String recipeName;
        private boolean publicityStatus;

        @Builder
        public RecipeCreateRequest(String recipeName, boolean publicityStatus) {
            this.recipeName = recipeName;
            this.publicityStatus = publicityStatus;
        }
    }
}
