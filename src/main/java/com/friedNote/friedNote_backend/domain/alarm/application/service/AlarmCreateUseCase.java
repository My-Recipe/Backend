package com.friedNote.friedNote_backend.domain.alarm.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.Email.EmailSendService;
import com.friedNote.friedNote_backend.domain.alarm.application.dto.request.AlarmRequest;
import com.friedNote.friedNote_backend.domain.alarm.application.mapper.AlarmMapper;
import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import com.friedNote.friedNote_backend.domain.alarm.domain.service.AlarmSaveService;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@UseCase
@RequiredArgsConstructor
@Transactional
public class AlarmCreateUseCase {

    private final InventoryQueryService inventoryQueryService;
    private final AlarmSaveService alarmSaveService;
    private final EmailSendService emailSendService;

    public void createAlarm(AlarmRequest.AlarmCreateRequest alarmCreateRequest) {
        Long deadline = alarmCreateRequest.getDeadline();
        String email = alarmCreateRequest.getEmail();
        Long inventoryId = alarmCreateRequest.getInventoryId();
        Inventory inventory = inventoryQueryService.findById(inventoryId);

        Alarm alarm = AlarmMapper.mapToAlarm(deadline, email, inventory);

//        emailSendService.sendEmail(alarmCreateRequest);
        checkConditionSendEmail(alarmCreateRequest);
        alarmSaveService.saveAlarm(alarm);
    }
    //알람 조건 확인
    //유통 기한 -> inventory에서 가져옴, 기한 -> alarm에서 가져옴
    public void checkConditionSendEmail(AlarmRequest.AlarmCreateRequest alarmCreateRequest){
        Long deadline = alarmCreateRequest.getDeadline();
        Long inventoryId = alarmCreateRequest.getInventoryId();
        Inventory inventory = inventoryQueryService.findById(inventoryId);

        LocalDate expirationDate = inventory.getExpirationDate();
        LocalDate nowDate = LocalDate.now();

        if (ChronoUnit.DAYS.between(nowDate, expirationDate) <= deadline) {
            emailSendService.sendEmail(alarmCreateRequest);
        }
    }
}
