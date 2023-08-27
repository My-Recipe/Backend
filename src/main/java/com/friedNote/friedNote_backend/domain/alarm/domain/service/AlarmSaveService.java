package com.friedNote.friedNote_backend.domain.alarm.domain.service;

import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import com.friedNote.friedNote_backend.domain.alarm.domain.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AlarmSaveService {

    private final AlarmRepository alarmRepository;

    public void saveAlarm(Alarm alarm) {
        alarmRepository.save(alarm);
    }
}
