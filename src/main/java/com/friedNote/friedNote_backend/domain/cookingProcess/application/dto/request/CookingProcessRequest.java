package com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CookingProcessRequest {

    @Getter
    @NoArgsConstructor
    public static class CookingProcessCreateRequest {
        private String description;
        private String imageUrl;
        private String tip;
        private Long time;
        private Long recipeId;

        @Builder
        public CookingProcessCreateRequest(String description, String imageUrl, String tip, Long time, Long recipeId) {
            this.description = description;
            this.imageUrl = imageUrl;
            this.tip = tip;
            this.time = time;
            this.recipeId = recipeId;
        }
    }
}
