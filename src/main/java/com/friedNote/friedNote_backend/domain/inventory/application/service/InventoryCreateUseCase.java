package com.friedNote.friedNote_backend.domain.inventory.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.friedNote.friedNote_backend.domain.inventory.application.mapper.InventoryMapper;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventorySaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@UseCase
@RequiredArgsConstructor
@Transactional
public class InventoryCreateUseCase {

    private final InventorySaveService inventorySaveService;

    public void createInventory(InventoryRequest.InventoryCreateRequest inventoryCreateRequest) {
        String name = inventoryCreateRequest.getName();
        String quantity = inventoryCreateRequest.getQuantity();
        LocalDate expirationDate = inventoryCreateRequest.getExpirationDate();
        LocalDate registrationDate = inventoryCreateRequest.getRegistrationDate();
        String sequence = inventoryCreateRequest.getSequence();

        Inventory inventory = InventoryMapper.mapToInventory(name, quantity, expirationDate, registrationDate, sequence);
        inventorySaveService.saveInventory(inventory);
    }
}
