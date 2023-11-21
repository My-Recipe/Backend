package com.friedNote.friedNote_backend.domain.recipeBook.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecipeBookResponse {

    @Getter
    @NoArgsConstructor
    public static class RecipeBookInfoResponse {
        @Schema(description = "레시피북 제목", defaultValue = "title")
        private String title;
        @Schema(description = "레시피북 부제목", defaultValue = "subtitle")
        private String subtitle;
        @Schema(description = "레시피북 공개 여부", defaultValue = "publicityStatus")
        private boolean publicityStatus;
        @Schema(description = "레시피북 레시피 수", defaultValue = "recipeCount")
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
