package com.friedNote.friedNote_backend.domain.ingredientGroup.domain.repository;

import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientGroupRepository extends JpaRepository<IngredientGroup, Long> {

    List<IngredientGroup> findIngredientGroupByRecipeId(Long recipeId);
    List<IngredientGroup> findByRecipeId(Long recipeId);
}
