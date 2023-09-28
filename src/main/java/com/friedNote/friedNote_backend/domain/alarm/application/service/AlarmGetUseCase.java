package com.friedNote.friedNote_backend.domain.alarm.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import com.friedNote.friedNote_backend.domain.alarm.domain.service.AlarmQueryService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AlarmGetUseCase {

    private final AlarmQueryService alarmQueryService;

    public Alarm getAlarm(Long inventoryId) {
        Alarm alarm = alarmQueryService.findByInventoryId(inventoryId);
        return alarm;
    }
}
