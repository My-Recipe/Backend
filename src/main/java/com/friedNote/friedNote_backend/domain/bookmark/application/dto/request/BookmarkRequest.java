package com.friedNote.friedNote_backend.domain.bookmark.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class BookmarkRequest {

    @Getter
    @RequiredArgsConstructor
    public static class BookmarkCreateRequest {
        @Schema(description = "레시피 식별자", defaultValue = "recipeId")
        private Long recipeId;
        @Schema(description = "유저 식별자", defaultValue = "userId")
        private Long userId;

        @Builder
        public BookmarkCreateRequest(Long recipeId, Long userId) {
            this.recipeId = recipeId;
            this.userId = userId;
        }
    }
}
