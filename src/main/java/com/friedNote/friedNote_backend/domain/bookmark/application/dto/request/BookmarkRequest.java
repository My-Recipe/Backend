package com.friedNote.friedNote_backend.domain.bookmark.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class BookmarkRequest {

    @Getter
    @RequiredArgsConstructor
    public static class BookmarkCreateRequest {

        private Long recipeId;

        private Long userId;

        @Builder
        public BookmarkCreateRequest(Long recipeId, Long userId) {
            this.recipeId = recipeId;
            this.userId = userId;
        }
    }
}
