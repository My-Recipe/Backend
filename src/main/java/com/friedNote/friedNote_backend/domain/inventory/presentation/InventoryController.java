package com.friedNote.friedNote_backend.domain.inventory.presentation;

import com.friedNote.friedNote_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.response.InventoryResponse;
import com.friedNote.friedNote_backend.domain.inventory.application.service.InventoryCreateUseCase;
import com.friedNote.friedNote_backend.domain.inventory.application.service.InventoryGetUseCase;
import com.friedNote.friedNote_backend.domain.inventory.application.service.InventoryUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryCreateUseCase inventoryCreateUseCase;
    private final InventoryUpdateUseCase inventoryUpdateUseCase;
    private final InventoryGetUseCase inventoryGetUseCase;

    @PostMapping("/inventory")
    public void createInventory(@RequestBody InventoryRequest.InventoryCreateRequest inventoryCreateRequest) {
        inventoryCreateUseCase.createInventory(inventoryCreateRequest);
    }
    @GetMapping("/inventory")
    public List<InventoryResponse.InventoryInfoResponse> getInventoryList(Long userId) {
        return inventoryGetUseCase.getInventoryList(userId);
    }
    @PostMapping("/inventory/update")
    public void updateInventory(@RequestBody InventoryRequest.InventoryUpdateRequest inventoryUpdateRequest) {
        inventoryUpdateUseCase.updateInventory(inventoryUpdateRequest);
    }

}
