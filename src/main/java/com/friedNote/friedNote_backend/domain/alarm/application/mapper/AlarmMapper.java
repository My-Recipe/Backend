package com.friedNote.friedNote_backend.domain.alarm.application.mapper;

import com.friedNote.friedNote_backend.domain.alarm.application.dto.response.AlarmResponse;
import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class AlarmMapper {

    public static Alarm mapToAlarm(Long deadline, String email, Inventory inventory) {
        return Alarm.builder()
                .deadline(deadline)
                .email(email)
                .inventory(inventory)
                .build();
    }
    public static AlarmResponse.AlarmInfoResponse mapToAlarmInfo(Alarm alarm) {
        return AlarmResponse.AlarmInfoResponse.builder()
                .deadline(alarm.getDeadline())
                .email(alarm.getEmail())
                .build();
    }
}
