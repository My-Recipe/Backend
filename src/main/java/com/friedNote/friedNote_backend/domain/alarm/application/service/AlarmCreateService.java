package com.friedNote.friedNote_backend.domain.alarm.application.service;

import com.friedNote.friedNote_backend.domain.alarm.application.dto.request.AlarmRequest;
import com.friedNote.friedNote_backend.domain.alarm.application.mapper.AlarmMapper;
import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import com.friedNote.friedNote_backend.domain.alarm.domain.service.AlarmSaveService;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlarmCreateService {

    private final InventoryQueryService inventoryQueryService;
    private final AlarmSaveService alarmSaveService;

    public void createAlarm(AlarmRequest.AlarmCreateRequest alarmCreateRequest) {
        Long deadline = alarmCreateRequest.getDeadline();
        String email = alarmCreateRequest.getEmail();
        Long inventoryId = alarmCreateRequest.getInventoryId();
        Inventory inventory = inventoryQueryService.findById(inventoryId);

        Alarm alarm = AlarmMapper.mapToAlarm(deadline, email, inventory);
        alarmSaveService.saveAlarm(alarm);
    }
}
