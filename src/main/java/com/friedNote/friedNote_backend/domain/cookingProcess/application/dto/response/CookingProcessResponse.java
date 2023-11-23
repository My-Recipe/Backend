package com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class CookingProcessResponse {

    @Getter
    public static class CookingProcessInfoResponse {

        @Schema(description = "요리 과정 설명", defaultValue = "description")
        private String description;
        @Schema(description = "요리 과정 이미지", defaultValue = "imageUrl")
        private String imageUrl;
        @Schema(description = "요리 팁", defaultValue = "tip")
        private String tip;
        @Schema(description = "요리 시간", defaultValue = "time")
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
