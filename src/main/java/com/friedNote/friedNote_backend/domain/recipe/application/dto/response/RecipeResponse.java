package com.friedNote.friedNote_backend.domain.recipe.application.dto.response;

import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.response.CookingProcessResponse;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.response.IngredientGroupResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class RecipeResponse {

    @Getter
    public static class RecipeNameResponse{
        private String recipeName;

        @Builder
        public RecipeNameResponse(String recipeName) {
            this.recipeName = recipeName;
        }
    }

    @Getter
    public static class RecipeListResponse {

        private Long recipeId;
        private String recipeName;
        private Long userId;
        private String userName;
        private String imageUrl;
        private String description;
        private boolean bookmark;

        @Builder
        public RecipeListResponse(Long recipeId, String recipeName, Long userId, String userName, String imageUrl,
                                     String description, boolean bookmark) {
            this.recipeId = recipeId;
            this.recipeName = recipeName;
            this.userId = userId;
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

    @Getter
    public static class RecipeInfoResponse {

        private String bookTitle;
        private String userName;
        private String recipeName;
        private List<IngredientGroupResponse.IngredientGroupInfoResponse> ingredientGroupList;
        private List<CookingProcessResponse.CookingProcessInfoResponse> cookingProcessList;

        @Builder
        public RecipeInfoResponse(String bookTitle, String userName, String recipeName, List<IngredientGroupResponse.IngredientGroupInfoResponse> ingredientGroupList, List<CookingProcessResponse.CookingProcessInfoResponse> cookingProcessList) {
            this.bookTitle = bookTitle;
            this.userName = userName;
            this.recipeName = recipeName;
            this.ingredientGroupList = ingredientGroupList;
            this.cookingProcessList = cookingProcessList;
        }
    }
}
