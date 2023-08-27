package com.friedNote.friedNote_backend.domain.inventory.domain.service;

import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
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
