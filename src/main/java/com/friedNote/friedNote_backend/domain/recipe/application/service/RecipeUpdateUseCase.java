package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.service.CookingProcessUpdateUseCase;
import com.friedNote.friedNote_backend.domain.ingredient.application.service.IngredientUpdateUseCase;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request.IngredientGroupRequest;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.service.IngredientGroupUpdateUseCase;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Slf4j
public class RecipeUpdateUseCase {

    private final RecipeQueryService recipeQueryService;
//    private final CookingProcessQueryService cookingProcessQueryService;
//    private final IngredientGroupQueryService ingredientGroupQueryService;
    private final CookingProcessUpdateUseCase cookingProcessUpdateUseCase;
    private final IngredientGroupUpdateUseCase ingredientGroupUpdateUseCase;
    private final IngredientUpdateUseCase ingredientUpdateUseCase;


    @Transactional
    public void updateRecipe(RecipeRequest.RecipeUpdateRequest recipeUpdateRequest) {
        String recipeName = recipeUpdateRequest.getRecipeName();
        boolean publicityStatus = recipeUpdateRequest.isPublicityStatus();
        log.info("recipeId: {}", recipeUpdateRequest.getRecipeId());
        Long recipeId = recipeUpdateRequest.getRecipeId();
        List<CookingProcessRequest.CookingProcessUpdateRequest> cookingProcessUpdateRequestList
                = recipeUpdateRequest.getCookingProcessUpdateRequestList();
        List<IngredientGroupRequest.IngredientGroupUpdateRequest> ingredientGroupUpdateRequestList
                = recipeUpdateRequest.getIngredientGroupUpdateRequestList();
        Recipe recipe = recipeQueryService.findRecipeById(recipeId);
//        List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipeId(recipeId);
//        List<IngredientGroup> ingredientGroupList = ingredientGroupQueryService.findByRecipeId(recipeId);

        recipe.updateRecipeName(recipeName);
        recipe.updatePublicityStatus(publicityStatus);
        recipeUpdateRequest.getCookingProcessUpdateRequestList().forEach(cookingProcessUpdateRequest -> {
            cookingProcessUpdateUseCase.updateCookingProcess(cookingProcessUpdateRequest);
        });
        //재료그룹
        recipeUpdateRequest.getIngredientGroupUpdateRequestList().forEach(ingredientGroupUpdateRequest -> {
            ingredientGroupUpdateUseCase.updateIngredientGroup(ingredientGroupUpdateRequest);
//            ingredientGroupUpdateRequest.getIngredientUpdateRequestList().forEach(ingredientUpdateRequest -> {
//                ingredientUpdateUseCase.updateIngredient(ingredientUpdateRequest);
//                log.info("RecipeUpdateUseCase 속 ingredientGroupId : {}", ingredientUpdateRequest.getIngredientGroupId());
//            });
        });
    }
}
