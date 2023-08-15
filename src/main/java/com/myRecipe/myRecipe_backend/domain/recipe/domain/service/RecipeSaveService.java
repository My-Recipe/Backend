package com.myRecipe.myRecipe_backend.domain.recipe.domain.service;

import com.myRecipe.myRecipe_backend.domain.recipe.domain.entity.Recipe;
import com.myRecipe.myRecipe_backend.domain.recipe.domain.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeSaveService {

    private final RecipeRepository recipeRepository;

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
