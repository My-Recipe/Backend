package com.friedNote.friedNote_backend.domain.alarm.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.alarm.application.dto.response.AlarmResponse;
import com.friedNote.friedNote_backend.domain.alarm.application.mapper.AlarmMapper;
import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import com.friedNote.friedNote_backend.domain.alarm.domain.service.AlarmQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class AlarmGetUseCase {

    private final AlarmQueryService alarmQueryService;

    public AlarmResponse.AlarmInfoResponse getAlarm(Long inventoryId) {
        Alarm alarm = alarmQueryService.findByInventoryId(inventoryId);
        AlarmResponse.AlarmInfoResponse alarmInfoResponse = AlarmMapper.mapToAlarmInfo(alarm);

        return alarmInfoResponse;
    }
}
