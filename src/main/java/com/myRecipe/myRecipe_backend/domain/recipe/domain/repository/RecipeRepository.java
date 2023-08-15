package com.myRecipe.myRecipe_backend.domain.recipe.domain.repository;

import com.myRecipe.myRecipe_backend.domain.recipe.domain.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
