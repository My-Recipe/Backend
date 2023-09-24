package com.friedNote.friedNote_backend.domain.ingredient.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.ingredient.domain.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class IngredientQueryService {

    private final IngredientRepository ingredientRepository;

    public Ingredient findIngredientById(Long ingredientId) {
        return ingredientRepository.findIngredientById(ingredientId);
    }
}
