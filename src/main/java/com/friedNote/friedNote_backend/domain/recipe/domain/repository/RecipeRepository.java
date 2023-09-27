package com.friedNote.friedNote_backend.domain.recipe.domain.repository;

import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findRecipeByUserIdOrderByCreatedDateDesc(Long userId);

    Long countRecipeByUserId(Long userId);

    boolean existsByUserIdAndId(Long userId, Long recipeId);

    Recipe findRecipeById(Long recipeId);

    List<Recipe> findAll();
}
