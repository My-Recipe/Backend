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


        @Builder
        public RecipeBookInfoResponse(String title, String subtitle) {
            this.title = title;
            this.subtitle = subtitle;
        }
    }
}
