package com.friedNote.friedNote_backend.domain.alarm.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import com.friedNote.friedNote_backend.domain.alarm.domain.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class AlarmQueryService {

    private final AlarmRepository alarmRepository;

    public Alarm findByInventoryId(Long inventoryId) {
        Alarm alarm = alarmRepository.findByInventoryId(inventoryId);
        return alarm;
    }
}
