package com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request;

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

        private String cookingProcessSequence;
        private String description;
        private MultipartFile image;
        private boolean representativeImageStatus;
        private String tip;
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

        private String cookingProcessSequence;
        private String description;
        private MultipartFile image;
        private boolean representativeImageStatus;
        private String tip;
        private Long time;
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
