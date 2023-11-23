package com.friedNote.friedNote_backend.domain.user.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponse {
    @Getter
    @NoArgsConstructor
    public static class UserInfoResponse {
        @Schema(description = "사용자 이름", defaultValue = "name")
        private String name;
        @Schema(description = "사용자 이메일", defaultValue = "email")
        private String email;
        @Schema(description = "사용자 프로필 사진", defaultValue = "profileUrl")
        private String profileUrl;

        @Builder
        public UserInfoResponse(String name, String email, String profileUrl) {
            this.name = name;
            this.email = email;
            this.profileUrl = profileUrl;
        }
    }
}
