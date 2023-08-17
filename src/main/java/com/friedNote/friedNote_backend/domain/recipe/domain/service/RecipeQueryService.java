package com.friedNote.friedNote_backend.domain.recipe.domain.service;

import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeQueryService {

    private final RecipeRepository recipeRepository;

    public Recipe findById(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
        return recipe;
    }
}
