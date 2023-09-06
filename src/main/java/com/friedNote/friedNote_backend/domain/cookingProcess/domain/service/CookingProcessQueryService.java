package com.friedNote.friedNote_backend.domain.cookingProcess.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.repository.CookingProcessRepository;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class CookingProcessQueryService {

    private final CookingProcessRepository cookingProcessRepository;

    public List<CookingProcess> findByRecipe(Recipe recipe) {
        return cookingProcessRepository.findByRecipe(recipe);
    }
    
    public List<CookingProcess> findCookingProcessByRecipeIdOrderByCookingProcessSequenceAsc(Long recipeId) {
        return cookingProcessRepository.findCookingProcessByRecipeIdOrderByCookingProcessSequenceAsc(recipeId);
    }
}
