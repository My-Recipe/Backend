package com.friedNote.friedNote_backend.domain.ingredientGroup.domain.repository;

import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientGroupRepository extends JpaRepository<IngredientGroup, Long> {
}
