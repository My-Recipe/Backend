package com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.response;

import com.friedNote.friedNote_backend.domain.ingredient.application.dto.response.IngredientResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class IngredientGroupResponse {

    @Getter
    @NoArgsConstructor
    public static class IngredientGroupInfoResponse {
        private String groupName;
        private List<IngredientResponse.IngredientInfoResponse> ingredientList;

        @Builder
        public IngredientGroupInfoResponse(String groupName, List<IngredientResponse.IngredientInfoResponse> ingredientList) {
            this.groupName = groupName;
            this.ingredientList = ingredientList;
        }
    }
}
