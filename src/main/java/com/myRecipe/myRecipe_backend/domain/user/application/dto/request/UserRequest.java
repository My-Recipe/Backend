package com.myRecipe.myRecipe_backend.domain.user.application.dto.request;

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
        private Long recipeBookId;

        @Builder
        public UserCreateRequest(String name, String email, String profileUrl, Long recipeBookId) {
            this.name = name;
            this.email = email;
            this.profileUrl = profileUrl;
            this.recipeBookId = recipeBookId;
        }
    }
}
