package com.friedNote.friedNote_backend.domain.inventory.application.service;

import com.friedNote.friedNote_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.friedNote.friedNote_backend.domain.inventory.application.mapper.InventoryMapper;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventorySaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InventoryCreateService {

    private final InventorySaveService inventorySaveService;

    public void createInventory(InventoryRequest.InventoryCreateRequest inventoryCreateRequest) {
        String name = inventoryCreateRequest.getName();
        String quantity = inventoryCreateRequest.getQuantity();
        LocalDate expirationDate = inventoryCreateRequest.getExpirationDate();
        LocalDate registrationDate = inventoryCreateRequest.getRegistrationDate();

        Inventory inventory = InventoryMapper.mapToInventory(name, quantity, expirationDate, registrationDate);
        inventorySaveService.saveInventory(inventory);
    }
}
