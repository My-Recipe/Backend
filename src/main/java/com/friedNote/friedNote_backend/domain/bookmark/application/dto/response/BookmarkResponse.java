package com.friedNote.friedNote_backend.domain.bookmark.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookmarkResponse {

    @Getter
    @NoArgsConstructor
    public static class BookmarkInfoResponse{

            private Long recipeId;

            private Long userId;

            private boolean isBookMark;

            @Builder
            public BookmarkInfoResponse(Long recipeId, Long userId, boolean isBookMark) {
                this.recipeId = recipeId;
                this.userId = userId;
                this.isBookMark = isBookMark;
            }
    }
}
