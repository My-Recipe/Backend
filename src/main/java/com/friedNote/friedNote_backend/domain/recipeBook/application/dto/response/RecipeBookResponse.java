package com.friedNote.friedNote_backend.domain.recipeBook.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecipeBookResponse {

    @Getter
    @NoArgsConstructor
    public static class RecipeBookInfoResponse {
        private String title;
        private String subtitle;
        private boolean publicityStatus;
        private Long recipeCount;

        @Builder
        public RecipeBookInfoResponse(String title, String subtitle, boolean publicityStatus, Long recipeCount) {
            this.title = title;
            this.subtitle = subtitle;
            this.publicityStatus = publicityStatus;
            this.recipeCount = recipeCount;
        }
    }
}
