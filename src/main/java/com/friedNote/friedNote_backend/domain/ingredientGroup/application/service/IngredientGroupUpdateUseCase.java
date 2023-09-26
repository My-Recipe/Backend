package com.friedNote.friedNote_backend.domain.ingredientGroup.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.ingredient.application.service.IngredientUpdateUseCase;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.request.IngredientGroupRequest;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.service.IngredientGroupQueryService;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Slf4j
public class IngredientGroupUpdateUseCase {

    private final IngredientGroupQueryService ingredientGroupQueryService;
    private final IngredientUpdateUseCase ingredientUpdateUseCase;
    private final RecipeQueryService recipeQueryService;

    public void updateIngredientGroup(IngredientGroupRequest.IngredientGroupUpdateRequest ingredientGroupUpdateRequest) {
        String groupName = ingredientGroupUpdateRequest.getGroupName();
        Long recipeId = ingredientGroupUpdateRequest.getRecipeId();
//        List<IngredientRequest.IngredientUpdateRequest> ingredientList = ingredientGroupUpdateRequest.getIngredientList();

        List<IngredientGroup> ingredientGroupList = ingredientGroupQueryService.findByRecipeId(recipeId);
//
//        ingredientGroupList.forEach(ingredientGroup -> {
//            ingredientGroup.updateIngredientGroupName(groupName);
////            ingredientList.forEach(ingredientUpdateRequest -> {
////                ingredientUpdateUseCase.updateIngredient(ingredientUpdateRequest);
////            });
//            log.info("ingredientGroup.getRecipe().getId(): {}", ingredientGroup.getRecipe().getId());
//            log.info("ingredientGroup.getId() : {}", ingredientGroup.getId());
//        });
        ingredientGroupList.forEach(ingredientGroup -> {
            ingredientGroup.updateIngredientGroupName(groupName);
        });
        ingredientGroupUpdateRequest.getIngredientUpdateRequestList().forEach(ingredientUpdateRequest -> {
            ingredientUpdateUseCase.updateIngredient(ingredientUpdateRequest);
            log.info("IngredientGroupUpdateUseCase 속 ingredientGroupId : {}", ingredientUpdateRequest.getIngredientGroupId());
        });
    }
}
