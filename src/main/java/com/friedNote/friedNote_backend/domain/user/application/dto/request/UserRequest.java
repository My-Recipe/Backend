package com.friedNote.friedNote_backend.domain.user.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {
    @Getter
    @NoArgsConstructor
    public static class UserCreateRequest{
        private String name;
        private String email;
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
        private String name;

        private String email;
        private Long userId;

        private String profileUrl;
        @Builder
        public UserUpdateRequest(String name, String email, Long userId, String profileUrl) {
            this.name = name;
            this.email = email;
            this.userId = userId;
            this.profileUrl = profileUrl;
        }
    }
}
