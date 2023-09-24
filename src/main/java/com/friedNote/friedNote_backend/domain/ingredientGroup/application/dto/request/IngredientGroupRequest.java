package com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request;

import com.friedNote.friedNote_backend.domain.ingredient.application.dto.request.IngredientRequest.IngredientRequest;
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
        List<IngredientRequest.IngredientCreateRequest> ingredientList;

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
        private Long ingredientGroupId;
        List<IngredientRequest.IngredientUpdateRequest> ingredientList;
        @Builder
        public IngredientGroupUpdateRequest(String groupName, Long ingredientGroupId, List<IngredientRequest.IngredientUpdateRequest> ingredientList) {
            this.groupName = groupName;
            this.ingredientGroupId = ingredientGroupId;
            this.ingredientList = ingredientList;
        }
    }
}
