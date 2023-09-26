package com.friedNote.friedNote_backend.domain.recipe.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class RecipeResponse {

    @Getter
    public static class RecipeInfoResponse{
        private String recipeName;

        @Builder
        public RecipeInfoResponse(String recipeName) {
            this.recipeName = recipeName;
        }
    }

    @Getter
    public static class RecipeListResponse {

        private Long recipeId;
        private String recipeName;
        private String userName;
        private String imageUrl;
        private String description;
        private boolean bookmark;

        @Builder
        public RecipeListResponse(Long recipeId, String recipeName, String userName, String imageUrl,
                                     String description, boolean bookmark) {
            this.recipeId = recipeId;
            this.recipeName = recipeName;
            this.userName = userName;
            this.imageUrl = imageUrl;
            this.description = description;
            this.bookmark = bookmark;
        }
    }

    @Getter
    public static class RecipeMainResponse {
        private Long recipeId;
        private String recipeName;
        private String userName;
        private String description;
        private boolean bookmark;
        private String totalRecipeCount;

        @Builder
        public RecipeMainResponse(Long recipeId, String recipeName, String userName, String description, boolean bookmark, String totalRecipeCount) {
            this.recipeId = recipeId;
            this.recipeName = recipeName;
            this.userName = userName;
            this.description = description;
            this.bookmark = bookmark;
            this.totalRecipeCount = totalRecipeCount;
        }
    }
}
