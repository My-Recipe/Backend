package com.friedNote.friedNote_backend.domain.ingredientGroup.application.mapper;

import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request.IngredientGroupRequest;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientGroupMapper {

    public static IngredientGroup mapToIngredientGroup(IngredientGroupRequest.IngredientGroupCreateRequest
                                                               ingredientGroupCreateRequest, Recipe recipe) {
        return IngredientGroup.builder()
                .ingredientName(ingredientGroupCreateRequest.getIngredientName())
                .ingredientAmount(ingredientGroupCreateRequest.getIngredientAmount())
                .ingredientUnit(ingredientGroupCreateRequest.getIngredientUnit())
                .recipe(recipe)
                .build();
    }
}
