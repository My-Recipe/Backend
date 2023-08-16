package com.friedNote.friedNote_backend.domain.inventory.application.mapper;

import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class InventoryMapper {

    public static Inventory mapToInventory(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate) {
        return Inventory.builder()
                .name(name)
                .quantity(quantity)
                .expirationDate(expirationDate)
                .registrationDate(registrationDate)
                .build();
    }
}
