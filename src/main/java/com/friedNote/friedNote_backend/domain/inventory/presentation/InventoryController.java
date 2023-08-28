package com.friedNote.friedNote_backend.domain.inventory.presentation;

import com.friedNote.friedNote_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.friedNote.friedNote_backend.domain.inventory.application.service.InventoryCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryCreateUseCase inventoryCreateUseCase;

    @PostMapping("/inventory")
    public void createInventory(@RequestBody InventoryRequest.InventoryCreateRequest inventoryCreateRequest) {
        inventoryCreateUseCase.createInventory(inventoryCreateRequest);
    }
    
}
