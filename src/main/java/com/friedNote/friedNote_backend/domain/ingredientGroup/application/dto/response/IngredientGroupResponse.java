package com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.response;

import com.friedNote.friedNote_backend.domain.ingredient.application.dto.response.IngredientResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class IngredientGroupResponse {

    @Getter
    @NoArgsConstructor
    public static class IngredientGroupInfoResponse {
        @Schema(description = "재료 그룹 이름", defaultValue = "groupName")
        private String groupName;
        @Schema(description = "재료 리스트", defaultValue = "ingredientList")
        private List<IngredientResponse.IngredientInfoResponse> ingredientList;

        @Builder
        public IngredientGroupInfoResponse(String groupName, List<IngredientResponse.IngredientInfoResponse> ingredientList) {
            this.groupName = groupName;
            this.ingredientList = ingredientList;
        }
    }
}
