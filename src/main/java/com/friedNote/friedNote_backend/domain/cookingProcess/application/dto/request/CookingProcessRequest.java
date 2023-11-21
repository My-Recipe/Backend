package com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public class CookingProcessRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CookingProcessCreateRequest {
        @Schema(description = "요리 과정 순서", defaultValue = "cookingProcessSequence")
        private String cookingProcessSequence;
        @Schema(description = "요리 과정 설명", defaultValue = "description")
        private String description;
        @Schema(description = "요리 과정 이미지", defaultValue = "image")
        private MultipartFile image;
        @Schema(description = "대표 이미지 여부", defaultValue = "representativeImageStatus")
        private boolean representativeImageStatus;
        @Schema(description = "요리 팁", defaultValue = "tip")
        private String tip;
        @Schema(description = "요리 시간", defaultValue = "time")
        private Long time;

        @Builder
        public CookingProcessCreateRequest(String cookingProcessSequence, String description, MultipartFile image,
                                           boolean representativeImageStatus, String tip, Long time) {
            this.cookingProcessSequence = cookingProcessSequence;
            this.description = description;
            this.image = image;
            this.representativeImageStatus = representativeImageStatus;
            this.tip = tip;
            this.time = time;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CookingProcessUpdateRequest {
        @Schema(description = "요리 과정 순서", defaultValue = "cookingProcessSequence")
        private String cookingProcessSequence;
        @Schema(description = "요리 과정 설명", defaultValue = "description")
        private String description;
        @Schema(description = "요리 과정 이미지", defaultValue = "image")
        private MultipartFile image;
        @Schema(description = "대표 이미지 여부", defaultValue = "representativeImageStatus")
        private boolean representativeImageStatus;
        @Schema(description = "요리 팁", defaultValue = "tip")
        private String tip;
        @Schema(description = "요리 시간", defaultValue = "time")
        private Long time;
        @Schema(description = "레시피 식별자", defaultValue = "recipeId")
        private Long recipeId;

        @Builder
        public CookingProcessUpdateRequest(String cookingProcessSequence, String description, MultipartFile image, boolean representativeImageStatus, String tip, Long time, Long recipeId) {
            this.cookingProcessSequence = cookingProcessSequence;
            this.description = description;
            this.image = image;
            this.representativeImageStatus = representativeImageStatus;
            this.tip = tip;
            this.time = time;
            this.recipeId = recipeId;
        }
    }
}
