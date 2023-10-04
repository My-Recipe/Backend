package com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class CookingProcessResponse {

    @Getter
    public static class CookingProcessInfoResponse {

        private String description;
        private String imageUrl;
        private String tip;
        private Long time;

        @Builder
        public CookingProcessInfoResponse(String description, String imageUrl, String tip, Long time) {
            this.description = description;
            this.imageUrl = imageUrl;
            this.tip = tip;
            this.time = time;
        }
    }
}
