package com.myRecipe.myRecipe_backend.domain.inventory.domain.service;

import com.myRecipe.myRecipe_backend.domain.inventory.domain.entity.Inventory;
import com.myRecipe.myRecipe_backend.domain.inventory.domain.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryQueryService {

    private final InventoryRepository inventoryRepository;

    /**
     * Todo: 오류처리
     */
    public Inventory findById(Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow();
        return inventory;
    }
}
