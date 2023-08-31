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
        private String description;
        private MultipartFile image;
        private String tip;
        private Long time;

        @Builder
        public CookingProcessCreateRequest(String description, MultipartFile image, String tip, Long time) {
            this.description = description;
            this.image = image;
            this.tip = tip;
            this.time = time;
        }
    }
}
