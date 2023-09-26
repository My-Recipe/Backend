package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.service.CookingProcessUpdateUseCase;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.service.IngredientGroupUpdateUseCase;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class RecipeUpdateUseCase {

    private final RecipeQueryService recipeQueryService;
    private final CookingProcessUpdateUseCase cookingProcessUpdateUseCase;
    private final IngredientGroupUpdateUseCase ingredientGroupUpdateUseCase;


    @Transactional
    public void updateRecipe(RecipeRequest.RecipeUpdateRequest recipeUpdateRequest) {
        String recipeName = recipeUpdateRequest.getRecipeName();
        boolean publicityStatus = recipeUpdateRequest.isPublicityStatus();
        Long recipeId = recipeUpdateRequest.getRecipeId();
        Recipe recipe = recipeQueryService.findRecipeById(recipeId);

        recipe.updateRecipeInfo(recipeName, publicityStatus);
        recipeUpdateRequest.getCookingProcessUpdateRequestList().forEach(cookingProcessUpdateRequest -> {
            cookingProcessUpdateUseCase.updateCookingProcess(cookingProcessUpdateRequest);
        });
        recipeUpdateRequest.getIngredientGroupUpdateRequestList().forEach(ingredientGroupUpdateRequest -> {
            ingredientGroupUpdateUseCase.updateIngredientGroup(ingredientGroupUpdateRequest);
        });
    }
}
