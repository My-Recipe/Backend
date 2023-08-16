package com.friedNote.friedNote_backend.domain.user.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponse {
    @Getter
    @NoArgsConstructor
    public static class UserInfoResponse {
        private String name;
        private String email;
        private String profileUrl;

        @Builder
        public UserInfoResponse(String name, String email, String profileUrl) {
            this.name = name;
            this.email = email;
            this.profileUrl = profileUrl;
        }
    }
}
