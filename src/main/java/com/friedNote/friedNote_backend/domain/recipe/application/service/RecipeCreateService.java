package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.mapper.RecipeMapper;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeCreateService {

    private final RecipeSaveService recipeSaveService;

    public void createRecipe(RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        String dishName = recipeCreateRequest.getRecipeName();
        boolean publicityStatus = recipeCreateRequest.isPublicityStatus();
        Recipe recipe = RecipeMapper.mapToRecipe(dishName, publicityStatus);

        recipeSaveService.saveRecipe(recipe);
    }

}

