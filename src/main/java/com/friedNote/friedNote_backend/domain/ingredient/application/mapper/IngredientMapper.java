package com.friedNote.friedNote_backend.domain.ingredient.application.mapper;

import com.friedNote.friedNote_backend.domain.ingredient.application.dto.request.IngredientRequest.IngredientRequest;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class IngredientMapper {

    public static Ingredient mapToIngredient(IngredientRequest.IngredientCreateRequest ingredientCreateRequest, IngredientGroup ingredientGroup) {
        return Ingredient.builder()
                .ingredientName(ingredientCreateRequest.getIngredientName())
                .ingredientAmount(ingredientCreateRequest.getIngredientAmount())
                .ingredientUnit(ingredientCreateRequest.getIngredientUnit())
                .ingredientGroup(ingredientGroup)
                .build();
    }

}
