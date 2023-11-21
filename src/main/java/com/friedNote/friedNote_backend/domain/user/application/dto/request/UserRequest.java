package com.friedNote.friedNote_backend.domain.user.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {

    @Getter
    @NoArgsConstructor
    public static class UserCreateRequest{
        @Schema(description = "유저 이름", defaultValue = "name")
        private String name;
        @Schema(description = "유저 이메일", defaultValue = "email")
        private String email;
        @Schema(description = "유저 프로필 사진", defaultValue = "profileUrl")
        private String profileUrl;
        @Builder
        public UserCreateRequest(String name, String email, String profileUrl) {
            this.name = name;
            this.email = email;
            this.profileUrl = profileUrl;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UserUpdateRequest{
        @Schema(description = "사용자 이름", defaultValue = "name")
        private String name;
        @Schema(description = "사용자 이메일", defaultValue = "email")
        private String email;
        @Schema(description = "사용자 식별자", defaultValue = "userId")
        private Long userId;
        @Schema(description = "사용자 프로필 사진", defaultValue = "profileUrl")
        private String profileUrl;

        @Builder
        public UserUpdateRequest(String name, String email, Long userId, String profileUrl) {
            this.name = name;
            this.email = email;
            this.userId = userId;
            this.profileUrl = profileUrl;
        }
    }

    @Getter
    public static class UserSignUpRequest{

        @Schema(description = "사용자 이름", defaultValue = "name")
        private String name;
        @Schema(description = "사용자 이메일", defaultValue = "email")
        private String email;

        @Builder
        public UserSignUpRequest(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}
