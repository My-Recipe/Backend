package com.myRecipe.myRecipe_backend.domain.inventory.domain.service;

import com.myRecipe.myRecipe_backend.domain.inventory.domain.entity.Inventory;
import com.myRecipe.myRecipe_backend.domain.inventory.domain.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventorySaveService {

    private final InventoryRepository inventoryRepository;

    public void saveInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }
}
