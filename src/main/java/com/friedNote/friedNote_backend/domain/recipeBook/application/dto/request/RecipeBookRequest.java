package com.friedNote.friedNote_backend.domain.recipeBook.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecipeBookRequest {

    @Getter
    @NoArgsConstructor
    public static class RecipeBookCreateRequest {

        @Schema(description = "레시피북 제목", defaultValue = "title")
        private String title;
        @Schema(description = "레시피북 부제목", defaultValue = "subtitle")
        private String subtitle;
        @Schema(description = "레시피북 공개 여부", defaultValue = "publicityStatus")
        private boolean publicityStatus;

        @Builder
        public RecipeBookCreateRequest(String title, String subtitle, boolean publicityStatus) {
            this.title = title;
            this.subtitle = subtitle;
            this.publicityStatus = publicityStatus;
        }

    }
    @Getter
    @NoArgsConstructor
    public static class RecipeBookUpdateRequest {
        @Schema(description = "레시피북 제목", defaultValue = "title")
        private String title;
        @Schema(description = "레시피북 부제목", defaultValue = "subtitle")
        private String subtitle;
        @Schema(description = "레시피북 공개 여부", defaultValue = "publicityStatus")
        private boolean publicityStatus;

        @Builder
        public RecipeBookUpdateRequest(String title, String subtitle, boolean publicityStatus) {
            this.title = title;
            this.subtitle = subtitle;
            this.publicityStatus = publicityStatus;
        }
    }


}
