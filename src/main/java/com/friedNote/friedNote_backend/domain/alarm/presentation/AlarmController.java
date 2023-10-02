package com.friedNote.friedNote_backend.domain.alarm.presentation;

import com.friedNote.friedNote_backend.domain.alarm.application.dto.request.AlarmRequest;
import com.friedNote.friedNote_backend.domain.alarm.application.dto.response.AlarmResponse;
import com.friedNote.friedNote_backend.domain.alarm.application.service.AlarmCreateUseCase;
import com.friedNote.friedNote_backend.domain.alarm.application.service.AlarmGetUseCase;
import com.friedNote.friedNote_backend.domain.alarm.application.service.AlarmUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmCreateUseCase alarmCreateUseCase;
    private final AlarmGetUseCase alarmGetUseCase;
    private final AlarmUpdateUseCase alarmUpdateUseCase;
    @PostMapping("/alarm")
    public void createAlarm(@RequestBody AlarmRequest.AlarmCreateRequest alarmCreateRequest) {
        alarmCreateUseCase.createAlarm(alarmCreateRequest);
    }
    @GetMapping("/alarm/{inventoryId}")
    public AlarmResponse.AlarmInfoResponse getAlarm(@PathVariable Long inventoryId) {
        return alarmGetUseCase.getAlarm(inventoryId);
    }
    @PostMapping("/alarm/update")
    public void updateAlarm(@RequestBody AlarmRequest.AlarmUpdateRequest alarmUpdateRequest) {
        alarmUpdateUseCase.updateAlarm(alarmUpdateRequest);
    }

}
