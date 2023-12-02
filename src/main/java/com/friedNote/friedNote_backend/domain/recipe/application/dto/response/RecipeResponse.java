package com.friedNote.friedNote_backend.domain.recipe.application.dto.response;

import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.response.CookingProcessResponse;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.response.IngredientGroupResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class RecipeResponse {

    @Getter
    public static class RecipeNameResponse{

        @Schema(description = "레시피 이름", defaultValue = "recipeName")
        private String recipeName;

        @Builder
        public RecipeNameResponse(String recipeName) {
            this.recipeName = recipeName;
        }
    }

    @Getter
    public static class RecipeListResponse {

        @Schema(description = "레시피 식별자", defaultValue = "recipeId")
        private Long recipeId;
        @Schema(description = "레시피 이름", defaultValue = "recipeName")
        private String recipeName;
        @Schema(description = "사용자 식별자", defaultValue = "userId")
        private Long userId;
        @Schema(description = "사용자 이름", defaultValue = "userName")
        private String userName;
        @Schema(description = "대표이미지", defaultValue = "imageUrl")
        private String imageUrl;
        @Schema(description = "레시피 설명", defaultValue = "description")
        private String description;
        @Schema(description = "북마크 여부", defaultValue = "bookmark")
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

        @Schema(description = "레시피 식별자", defaultValue = "recipeId")
        private Long recipeId;
        @Schema(description = "레시피 이름", defaultValue = "recipeName")
        private String recipeName;
        @Schema(description = "사용자 이름", defaultValue = "userName")
        private String userName;
        @Schema(description = "레시피 설명", defaultValue = "description")
        private String description;
        @Schema(description = "북마크 여부", defaultValue = "bookmark")
        private boolean bookmark;
        @Schema(description = "레시피 총 갯수", defaultValue = "totalRecipeCount")
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

        @Schema(description = "레시피북 제목", defaultValue = "bookTitle")
        private String bookTitle;
        @Schema(description = "레시피 식별자", defaultValue = "userName")
        private String userName;
        @Schema(description = "레시피 이름", defaultValue = "recipeName")
        private String recipeName;
        @Schema(description = "재료그룹 리스트", defaultValue = "ingredientGroupList")
        private List<IngredientGroupResponse.IngredientGroupInfoResponse> ingredientGroupList;
        @Schema(description = "조리과정 리스트", defaultValue = "cookingProcessList")
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
