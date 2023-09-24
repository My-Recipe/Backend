package com.friedNote.friedNote_backend.domain.ingredientGroup.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.repository.IngredientGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class IngredientGroupQueryService {

    private final IngredientGroupRepository ingredientGroupRepository;

    public List<IngredientGroup> findIngredientGroupByRecipeId(Long recipeId) {
        return ingredientGroupRepository.findIngredientGroupByRecipeId(recipeId);
    }

    public IngredientGroup findIngredientGroupById(Long ingredientGroupId) {
        return ingredientGroupRepository.findIngredientGroupById(ingredientGroupId);
    }
}
