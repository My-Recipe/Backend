package com.myRecipe.myRecipe_backend.domain.recipe.application.service;

import com.myRecipe.myRecipe_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.myRecipe.myRecipe_backend.domain.recipe.application.mapper.RecipeMapper;
import com.myRecipe.myRecipe_backend.domain.recipe.domain.entity.Recipe;
import com.myRecipe.myRecipe_backend.domain.recipe.domain.service.RecipeSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeCreateService {

    private final RecipeSaveService recipeSaveService;

    public void createRecipe(RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        String dishName = recipeCreateRequest.getDishName();
        boolean publicityStatus = recipeCreateRequest.isPublicityStatus();
        Recipe recipe = RecipeMapper.mapToRecipe(dishName, publicityStatus);

        recipeSaveService.saveRecipe(recipe);
    }

}

