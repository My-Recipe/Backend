package com.myRecipe.myRecipe_backend.domain.inventory.presentation;

import com.myRecipe.myRecipe_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.myRecipe.myRecipe_backend.domain.inventory.application.service.InventoryCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryCreateService inventoryCreateService;

    @PostMapping("/inventory")
    public void createInventory(@RequestBody InventoryRequest.InventoryCreateRequest inventoryCreateRequest) {
        inventoryCreateService.createInventory(inventoryCreateRequest);
    }
    
}
