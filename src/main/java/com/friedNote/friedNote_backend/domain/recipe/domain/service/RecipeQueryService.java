package com.friedNote.friedNote_backend.domain.recipe.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class RecipeQueryService {

    private final RecipeRepository recipeRepository;

    /**
     * Todo: 예외처리
     */
    public Recipe findRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findRecipeById(recipeId);
        return recipe;
    }

    public List<Recipe> findRecipeByUserId(Long userId) {
        List<Recipe> recipeListByUserId = recipeRepository.findRecipeByUserIdOrderByCreatedDateDesc(userId);
        return recipeListByUserId;
    }

    public Long countRecipeByUserId(Long userId) {
        return recipeRepository.countRecipeByUserId(userId);
    }

    public boolean existsByUserIdAndId(Long userId, Long recipeId) {
        return recipeRepository.existsByUserIdAndId(userId, recipeId);
    }
}
