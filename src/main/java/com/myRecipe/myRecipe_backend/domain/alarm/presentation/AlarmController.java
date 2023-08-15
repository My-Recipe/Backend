package com.myRecipe.myRecipe_backend.domain.alarm.presentation;

import com.myRecipe.myRecipe_backend.domain.alarm.application.dto.request.AlarmRequest;
import com.myRecipe.myRecipe_backend.domain.alarm.application.service.AlarmCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmCreateService alarmCreateService;
    @PostMapping("/alarm")
    public void createAlarm(@RequestBody AlarmRequest.AlarmCreateRequest alarmCreateRequest) {
        alarmCreateService.createAlarm(alarmCreateRequest);
    }

}
