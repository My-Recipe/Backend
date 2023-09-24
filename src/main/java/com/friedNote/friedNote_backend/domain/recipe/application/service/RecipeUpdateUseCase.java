package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.service.CookingProcessUpdateUseCase;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request.IngredientGroupRequest;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.service.IngredientGroupUpdateUseCase;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        List<CookingProcessRequest.CookingProcessUpdateRequest> cookingProcessUpdateRequestList
                = recipeUpdateRequest.getCookingProcessUpdateRequestList();
           List<IngredientGroupRequest.IngredientGroupUpdateRequest> ingredientGroupUpdateRequestList
                = recipeUpdateRequest.getIngredientGroupUpdateRequestList();
        Recipe recipe = recipeQueryService.findRecipeById(recipeId);

        if(recipe!=null) {
            recipe.updateRecipeName(recipeName);
            recipe.updatePublicityStatus(publicityStatus);
            cookingProcessUpdateRequestList.forEach(cookingProcessUpdateRequest -> {
                cookingProcessUpdateUseCase.updateCookingProcess(cookingProcessUpdateRequest);
            });
            ingredientGroupUpdateRequestList.forEach(ingredientGroupUpdateRequest -> {
                ingredientGroupUpdateUseCase.updateIngredientGroup(ingredientGroupUpdateRequest);
            });
        }
    }
}
