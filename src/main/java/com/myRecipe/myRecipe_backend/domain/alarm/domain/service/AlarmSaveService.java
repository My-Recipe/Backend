package com.myRecipe.myRecipe_backend.domain.alarm.domain.service;

import com.myRecipe.myRecipe_backend.domain.alarm.domain.entity.Alarm;
import com.myRecipe.myRecipe_backend.domain.alarm.domain.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlarmSaveService {

    private final AlarmRepository alarmRepository;

    public void saveAlarm(Alarm alarm) {
        alarmRepository.save(alarm);
    }
}
