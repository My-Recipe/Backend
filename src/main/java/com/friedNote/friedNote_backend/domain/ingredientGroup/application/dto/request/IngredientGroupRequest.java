package com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request;

import com.friedNote.friedNote_backend.domain.ingredient.application.dto.request.IngredientRequest;
import io.swagger.v3.oas.annotations.media.Schema;
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

        @Schema(description = "재료 그룹 이름", defaultValue = "groupName")
        private String groupName;
        @Schema(description = "재료 리스트", defaultValue = "ingredientList")
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

        @Schema(description = "재료 그룹 이름", defaultValue = "groupName")
        private String groupName;
        @Schema(description = "수정된 재료 리스트", defaultValue = "ingredientUpdateRequestList")
        private List<IngredientRequest.IngredientUpdateRequest> ingredientUpdateRequestList;
        @Schema(description = "레시피 식별자", defaultValue = "recipeId")
        private Long recipeId;

        @Builder
        public IngredientGroupUpdateRequest(String groupName, List<IngredientRequest.IngredientUpdateRequest> ingredientUpdateRequestList, Long recipeId) {
            this.groupName = groupName;
            this.ingredientUpdateRequestList = ingredientUpdateRequestList;
            this.recipeId = recipeId;
        }
    }
}
