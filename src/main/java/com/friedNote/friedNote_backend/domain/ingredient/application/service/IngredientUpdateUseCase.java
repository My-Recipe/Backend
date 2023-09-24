package com.friedNote.friedNote_backend.domain.ingredient.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.ingredient.application.dto.request.IngredientRequest.IngredientRequest;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.ingredient.domain.service.IngredientQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class IngredientUpdateUseCase {

    private final IngredientQueryService ingredientQueryService;

    public void updateIngredient(IngredientRequest.IngredientUpdateRequest ingredientUpdateRequest) {
        String ingredientName = ingredientUpdateRequest.getIngredientName();
        Long ingredientAmount = ingredientUpdateRequest.getIngredientAmount();
        Long ingredientId = ingredientUpdateRequest.getIngredientId();
        String ingredientUnit = ingredientUpdateRequest.getIngredientUnit();

        Ingredient ingredient = ingredientQueryService.findIngredientById(ingredientId);
        ingredient.updateIngredientName(ingredientName);
        ingredient.updateIngredientAmount(ingredientAmount);
        ingredient.updateIngredientUnit(ingredientUnit);
    }
}
