package com.friedNote.friedNote_backend.domain.ingredientGroup.application.mapper;

import com.friedNote.friedNote_backend.domain.ingredient.application.dto.response.IngredientResponse;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request.IngredientGroupRequest;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.response.IngredientGroupResponse;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientGroupMapper {

    public static IngredientGroup mapToIngredientGroup(IngredientGroupRequest.IngredientGroupCreateRequest
                                                               ingredientGroupCreateRequest, Recipe recipe) {
        return IngredientGroup.builder()
                .groupName(ingredientGroupCreateRequest.getGroupName())
                .recipe(recipe)
                .build();
    }

    public static IngredientGroupResponse.IngredientGroupInfoResponse mapToIngredientGroupInfoResponse(IngredientGroup ingredientGroup,
                                                                                                  List<IngredientResponse.IngredientInfoResponse> ingredientInfoResponseList) {
        return IngredientGroupResponse.IngredientGroupInfoResponse.builder()
                .groupName(ingredientGroup.getGroupName())
                .ingredientList(ingredientInfoResponseList)
                .build();
    }
}
