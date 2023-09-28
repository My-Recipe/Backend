package com.friedNote.friedNote_backend.domain.inventory.application.mapper;

import com.friedNote.friedNote_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.response.InventoryResponse;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class InventoryMapper {

    public static Inventory mapToInventory(InventoryRequest.InventoryCreateRequest inventoryCreateRequest, User user) {
        return Inventory.builder()
                .name(inventoryCreateRequest.getName())
                .quantity(inventoryCreateRequest.getQuantity())
                .expirationDate(inventoryCreateRequest.getExpirationDate())
                .registrationDate(inventoryCreateRequest.getRegistrationDate())
                .sequence(inventoryCreateRequest.getSequence())
                .user(user)
                .build();
    }

    public static InventoryResponse.InventoryInfoResponse mapToInventoryInfo(Inventory inventory) {
        return InventoryResponse.InventoryInfoResponse.builder()
                .name(inventory.getName())
                .quantity(inventory.getQuantity())
                .expirationDate(inventory.getExpirationDate())
                .registrationDate(inventory.getRegistrationDate())
                .sequence(inventory.getSequence())
                .build();
    }
}

