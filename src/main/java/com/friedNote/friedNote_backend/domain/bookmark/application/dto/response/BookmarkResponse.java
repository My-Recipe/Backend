package com.friedNote.friedNote_backend.domain.bookmark.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class BookmarkResponse {

    @Getter
    @NoArgsConstructor
    public static class BookmarkInfoResponse{
        @Schema(description = "레시피 식별자", defaultValue = "recipeId")
        private Long recipeId;
        @Schema(description = "북마크 여부", defaultValue = "isBookMark")
        private boolean isBookMark;
        @Schema(description = "북마크 생성 날짜", defaultValue = "createdDate")
        private LocalDateTime createdDate;
        @Schema(description = "레시피 이미지", defaultValue = "image")
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
        @Schema(description = "북마크 수", defaultValue = "count")
        private Long count;

        @Builder
        public BookmarkCountResponse(Long count) {
            this.count = count;
        }
    }
}
