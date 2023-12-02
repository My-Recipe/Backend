package com.friedNote.friedNote_backend.domain.recipe.application.dto.request;

import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request.IngredientGroupRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class RecipeRequest {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class RecipeCreateRequest {

        /**
         * 리스트 변수명 리팩토링 필요
         */
        @Schema(description = "레시피 이름", defaultValue = "name")
        private String recipeName;
        @Schema(description = "레시피 공개여부", defaultValue = "publicityStatus")
        private boolean publicityStatus;
        @Schema(description = "레시피북 식별자", defaultValue = "recipeBookId")
        private Long recipeBookId;
        @Schema(description = "사용자 식별자", defaultValue = "userId")
        private Long userId;
        @Schema(description = "조리과정 리스트", defaultValue = "cookingProcessCreateRequestList")
        private List<CookingProcessRequest.CookingProcessCreateRequest> cookingProcessCreateRequestList;
        @Schema(description = "재료그룹 리스트", defaultValue = "ingredientGroupCreateRequestList")
        private List<IngredientGroupRequest.IngredientGroupCreateRequest> ingredientGroupCreateRequestList;

        @Builder
        public RecipeCreateRequest(String recipeName, boolean publicityStatus, Long recipeBookId, Long userId, List<CookingProcessRequest.CookingProcessCreateRequest> cookingProcessCreateRequestList, List<IngredientGroupRequest.IngredientGroupCreateRequest> ingredientGroupCreateRequestList) {
            this.recipeName = recipeName;
            this.publicityStatus = publicityStatus;
            this.recipeBookId = recipeBookId;
            this.userId = userId;
            this.cookingProcessCreateRequestList = cookingProcessCreateRequestList;
            this.ingredientGroupCreateRequestList = ingredientGroupCreateRequestList;
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class RecipeUpdateRequest {

        @Schema(description = "레시피 이름", defaultValue = "name")
        private String recipeName;
        @Schema(description = "레시피 공개여부", defaultValue = "publicityStatus")
        private boolean publicityStatus;
        @Schema(description = "레시피 식별자", defaultValue = "recipeId")
        private Long recipeId;
        @Schema(description = "조리과정 리스트", defaultValue = "cookingProcessList")
        private List<CookingProcessRequest.CookingProcessUpdateRequest> CookingProcessUpdateRequestList;
        @Schema(description = "재료그룹 리스트", defaultValue = "ingredientGroupList")
        private List<IngredientGroupRequest.IngredientGroupUpdateRequest> ingredientGroupUpdateRequestList;

        @Builder
        public RecipeUpdateRequest(String recipeName, boolean publicityStatus, Long recipeId, List<CookingProcessRequest.CookingProcessUpdateRequest> cookingProcessUpdateRequestList, List<IngredientGroupRequest.IngredientGroupUpdateRequest> ingredientGroupUpdateRequestList) {
            this.recipeName = recipeName;
            this.publicityStatus = publicityStatus;
            this.recipeId = recipeId;
            this.CookingProcessUpdateRequestList = cookingProcessUpdateRequestList;
            this.ingredientGroupUpdateRequestList = ingredientGroupUpdateRequestList;
        }
    }
}
