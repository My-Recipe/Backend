package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.response.CookingProcessResponse;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.mapper.CookingProcessMapper;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessQueryService;
import com.friedNote.friedNote_backend.domain.ingredient.application.dto.response.IngredientResponse;
import com.friedNote.friedNote_backend.domain.ingredient.application.mapper.IngredientMapper;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.response.IngredientGroupResponse;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.mapper.IngredientGroupMapper;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.service.IngredientGroupQueryService;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.mapper.RecipeMapper;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class RecipeGetUseCase {

    private final RecipeQueryService recipeQueryService;
    private final IngredientGroupQueryService ingredientGroupQueryService;
    private final CookingProcessQueryService cookingProcessQueryService;

    public RecipeResponse.RecipeInfoResponse getRecipe(Long recipeId){
        Recipe recipe = recipeQueryService.findRecipeById(recipeId);
        List<IngredientGroupResponse.IngredientGroupInfoResponse> ingredientGroupInfoResponseList = getIngredientGroupInfoResponses(recipeId);
        List<CookingProcessResponse.CookingProcessInfoResponse> cookingProcessInfoResponseList = getCookingProcessInfoResponses(recipeId);

        RecipeResponse.RecipeInfoResponse recipeInfoResponse = 
                RecipeMapper.mapToRecipeInfoResponse(recipe, ingredientGroupInfoResponseList, cookingProcessInfoResponseList);

        return recipeInfoResponse;
    }

    public RecipeResponse.RecipeInfoResponse getRecipeByRecipeName(String recipeName) {
        Recipe recipe = recipeQueryService.findByRecipeName(recipeName);
        Long recipeId = recipe.getId();

        List<IngredientGroupResponse.IngredientGroupInfoResponse> ingredientGroupInfoResponseList = getIngredientGroupInfoResponses(recipeId);
        List<CookingProcessResponse.CookingProcessInfoResponse> cookingProcessInfoResponseList = getCookingProcessInfoResponses(recipeId);

        RecipeResponse.RecipeInfoResponse recipeInfoResponse =
                RecipeMapper.mapToRecipeInfoResponse(recipe, ingredientGroupInfoResponseList, cookingProcessInfoResponseList);

        return recipeInfoResponse;
    }
    
    
    private List<CookingProcessResponse.CookingProcessInfoResponse> getCookingProcessInfoResponses(Long recipeId) {
        List<CookingProcess> cookingProcessList = cookingProcessQueryService.findCookingProcessByRecipeIdOrderByCookingProcessSequenceAsc(recipeId);
        List<CookingProcessResponse.CookingProcessInfoResponse> cookingProcessInfoResponseList = cookingProcessList.stream().map(cookingProcess -> {
            CookingProcessResponse.CookingProcessInfoResponse cookingProcessInfoResponse = CookingProcessMapper.mapToCookingProcessInfoResponse(cookingProcess);
            return cookingProcessInfoResponse;
        }).collect(Collectors.toList());
        return cookingProcessInfoResponseList;
    }

    private List<IngredientGroupResponse.IngredientGroupInfoResponse> getIngredientGroupInfoResponses(Long recipeId) {
        List<IngredientGroup> ingredientGroupList = ingredientGroupQueryService.findByRecipeId(recipeId);
        List<IngredientGroupResponse.IngredientGroupInfoResponse> ingredientGroupInfoResponseList = ingredientGroupList.stream().map(ingredientGroup -> {
            List<Ingredient> ingredientList = ingredientGroup.getIngredientList();
            List<IngredientResponse.IngredientInfoResponse> ingredientInfoResponseList = ingredientList.stream().map(ingredient -> {
                IngredientResponse.IngredientInfoResponse ingredientInfoResponse = IngredientMapper.mapToIngredientInfoResponse(ingredient);
                return ingredientInfoResponse;
            }).collect(Collectors.toList());

            IngredientGroupResponse.IngredientGroupInfoResponse ingredientGroupInfoResponse
                    = IngredientGroupMapper.mapToIngredientGroupInfoResponse(ingredientGroup, ingredientInfoResponseList);
            return ingredientGroupInfoResponse;
        }).collect(Collectors.toList());
        return ingredientGroupInfoResponseList;
    }
}
