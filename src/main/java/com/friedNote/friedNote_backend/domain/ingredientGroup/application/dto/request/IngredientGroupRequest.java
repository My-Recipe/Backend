package com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request;

import com.friedNote.friedNote_backend.domain.ingredient.application.dto.request.IngredientRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class IngredientGroupRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class IngredientGroupCreateRequest {

        private String groupName;
        private List<IngredientRequest.IngredientCreateRequest> ingredientList;

        @Builder
        public IngredientGroupCreateRequest(String groupName, List<IngredientRequest.IngredientCreateRequest> ingredientList) {
            this.groupName = groupName;
            this.ingredientList = ingredientList;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class IngredientGroupUpdateRequest {

        private String groupName;
        private List<IngredientRequest.IngredientUpdateRequest> ingredientUpdateRequestList;
        private Long recipeId;

        @Builder
        public IngredientGroupUpdateRequest(String groupName, List<IngredientRequest.IngredientUpdateRequest> ingredientUpdateRequestList, Long recipeId) {
            this.groupName = groupName;
            this.ingredientUpdateRequestList = ingredientUpdateRequestList;
            this.recipeId = recipeId;
        }
    }
}
