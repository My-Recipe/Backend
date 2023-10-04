package com.friedNote.friedNote_backend.domain.bookmark.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class BookmarkResponse {

    @Getter
    @NoArgsConstructor
    public static class BookmarkInfoResponse{

            private Long recipeId;
            private boolean isBookMark;
            private LocalDateTime createdDate;
            private MultipartFile image;

            @Builder
            public BookmarkInfoResponse(Long recipeId, boolean isBookMark, LocalDateTime createdDate, MultipartFile image) {
                this.recipeId = recipeId;
                this.isBookMark = isBookMark;
                this.createdDate = createdDate;
                this.image = image;
            }
    }

    @Getter
    @NoArgsConstructor
    public static class BookmarkCountResponse {

        private Long count;

        @Builder
        public BookmarkCountResponse(Long count) {
            this.count = count;
        }
    }
}
