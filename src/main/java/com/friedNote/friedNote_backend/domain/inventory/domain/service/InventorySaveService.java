package com.friedNote.friedNote_backend.domain.inventory.domain.service;

import com.friedNote.friedNote_backend.common.DomainService;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class InventorySaveService {

    private final InventoryRepository inventoryRepository;

    public void saveInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }
}
