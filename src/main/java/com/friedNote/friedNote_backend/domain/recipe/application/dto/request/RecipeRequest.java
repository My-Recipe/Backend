package com.friedNote.friedNote_backend.domain.recipe.application.dto.request;

import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request.IngredientGroupRequest;
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

        private String recipeName;
        private boolean publicityStatus;
        private Long recipeBookId;
        private Long userId;
        private List<CookingProcessRequest.CookingProcessCreateRequest> cookingProcessCreateRequestList;
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
        private String recipeName;
        private boolean publicityStatus;

        private Long recipeId;
        private List<CookingProcessRequest.CookingProcessUpdateRequest> CookingProcessUpdateRequestList;
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
