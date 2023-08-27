package com.friedNote.friedNote_backend.domain.ingredientGroup.domain.service;

import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.repository.IngredientGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientGroupSaveService {

    private final IngredientGroupRepository ingredientGroupRepository;

    public void saveIngredientGroup(IngredientGroup ingredientGroup) {
        ingredientGroupRepository.save(ingredientGroup);
    }
}
