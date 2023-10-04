package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class RecipeNameListGetUseCase {

    private final RecipeQueryService recipeQueryService;

    public List<String> getRecipeNameList() {

        List<Recipe> recipeList = recipeQueryService.findAll();
        List<String> recipeNameList = recipeList.stream()
                        .map(recipe -> recipe.getRecipeName()).collect(Collectors.toList());
        return recipeNameList;
    }
}
