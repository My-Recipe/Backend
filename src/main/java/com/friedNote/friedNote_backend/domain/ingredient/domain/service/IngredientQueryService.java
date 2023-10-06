package com.friedNote.friedNote_backend.domain.ingredient.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.ingredient.domain.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class IngredientQueryService {

    private final IngredientRepository ingredientRepository;

    public Ingredient findIngredientById(Long ingredientId) {
        return ingredientRepository.findIngredientById(ingredientId);
    }

    public List<Ingredient> findByIngredientGroupId(Long ingredientGroupId) {
        return ingredientRepository.findByIngredientGroupId(ingredientGroupId);
    }

    public List<Ingredient> findByIngredientName(String ingredientName) {
        return ingredientRepository.findByIngredientName(ingredientName);
    }
}
