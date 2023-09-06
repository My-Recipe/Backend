package com.friedNote.friedNote_backend.domain.ingredient.domain.repository;

import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
