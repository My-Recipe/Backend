package com.friedNote.friedNote_backend.domain.inventory.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.common.util.UserUtils;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.friedNote.friedNote_backend.domain.inventory.application.mapper.InventoryMapper;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventorySaveService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class InventoryCreateUseCase {

    private final InventorySaveService inventorySaveService;
    private final UserUtils userUtils;

    public void createInventory(InventoryRequest.InventoryCreateRequest inventoryCreateRequest) {
        User user = userUtils.getUser();

        Inventory inventory = InventoryMapper.mapToInventory(inventoryCreateRequest ,user);
        inventorySaveService.saveInventory(inventory);
    }
}
