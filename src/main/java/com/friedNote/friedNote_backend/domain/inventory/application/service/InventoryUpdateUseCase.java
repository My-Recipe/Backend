package com.friedNote.friedNote_backend.domain.inventory.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.alarm.application.service.AlarmUpdateUseCase;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@UseCase
@RequiredArgsConstructor
public class InventoryUpdateUseCase {

    private final InventoryQueryService inventoryQueryService;
    private final AlarmUpdateUseCase alarmUpdateUseCase;

    @Transactional
    public void updateInventory(InventoryRequest.InventoryUpdateRequest inventoryUpdateRequest){
        LocalDate expirationDate = inventoryUpdateRequest.getExpirationDate();
        LocalDate registrationDate = inventoryUpdateRequest.getRegistrationDate();
        String name = inventoryUpdateRequest.getName();
        String quantity = inventoryUpdateRequest.getQuantity();
        String sequence = inventoryUpdateRequest.getSequence();
        Long inventoryId = inventoryUpdateRequest.getInventoryId();

        Inventory inventory = inventoryQueryService.findById(inventoryId);
        inventory.updateInventoryInfo(name, quantity, expirationDate, registrationDate, sequence);

        if(inventoryUpdateRequest.getAlarmUpdateRequest() != null){
            alarmUpdateUseCase.updateAlarm(inventoryUpdateRequest.getAlarmUpdateRequest());
        }
    }
}
