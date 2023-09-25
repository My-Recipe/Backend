package com.friedNote.friedNote_backend.domain.ingredient.domain.repository;

import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Ingredient findIngredientById(Long ingredientId);

    List<Ingredient> findByIngredientGroupId(Long ingredientGroupId);
}
