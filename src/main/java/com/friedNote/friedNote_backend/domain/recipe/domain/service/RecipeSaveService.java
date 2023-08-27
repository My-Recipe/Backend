package com.friedNote.friedNote_backend.domain.recipe.domain.service;

import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RecipeSaveService {

    private final RecipeRepository recipeRepository;

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
