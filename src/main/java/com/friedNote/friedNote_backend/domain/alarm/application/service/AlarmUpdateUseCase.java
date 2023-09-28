package com.friedNote.friedNote_backend.domain.alarm.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.Email.EmailSendService;
import com.friedNote.friedNote_backend.domain.alarm.application.dto.request.AlarmRequest;
import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import com.friedNote.friedNote_backend.domain.alarm.domain.service.AlarmQueryService;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@UseCase
@RequiredArgsConstructor
public class AlarmUpdateUseCase {

    private final AlarmQueryService alarmQueryService;
    private final InventoryQueryService inventoryQueryService;
    private final EmailSendService emailSendService;

    @Transactional
    public void updateAlarm(AlarmRequest.AlarmUpdateRequest alarmUpdateRequest){
        Long deadline = alarmUpdateRequest.getDeadline();
        String email = alarmUpdateRequest.getEmail();
        Long inventoryId = alarmUpdateRequest.getInventoryId();

        Alarm alarm = alarmQueryService.findByInventoryId(inventoryId);
        checkConditionSendEmail(alarmUpdateRequest);
        alarm.updateAlarm(deadline, email);
    }

    public void checkConditionSendEmail(AlarmRequest.AlarmUpdateRequest alarmUpdateRequest){
        Long deadline = alarmUpdateRequest.getDeadline();
        Long inventoryId = alarmUpdateRequest.getInventoryId();
        Inventory inventory = inventoryQueryService.findById(inventoryId);

        LocalDate expirationDate = inventory.getExpirationDate();
        LocalDate nowDate = LocalDate.now();

        if (ChronoUnit.DAYS.between(nowDate, expirationDate) <= deadline) {
            emailSendService.sendEmail(alarmUpdateRequest);
        }
    }
}
