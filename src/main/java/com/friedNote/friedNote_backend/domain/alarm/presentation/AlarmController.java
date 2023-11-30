package com.friedNote.friedNote_backend.domain.alarm.presentation;

import com.friedNote.friedNote_backend.common.exception.dto.ErrorResponse;
import com.friedNote.friedNote_backend.domain.alarm.application.dto.request.AlarmRequest;
import com.friedNote.friedNote_backend.domain.alarm.application.dto.response.AlarmResponse;
import com.friedNote.friedNote_backend.domain.alarm.application.service.AlarmCreateUseCase;
import com.friedNote.friedNote_backend.domain.alarm.application.service.AlarmGetUseCase;
import com.friedNote.friedNote_backend.domain.alarm.application.service.AlarmUpdateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmCreateUseCase alarmCreateUseCase;
    private final AlarmGetUseCase alarmGetUseCase;
    private final AlarmUpdateUseCase alarmUpdateUseCase;
    @Operation(summary = "알람 생성", tags = {"AlarmController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "알람 생성 성공"),
            @ApiResponse(responseCode = "404", description = "알람 생성 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/alarm")
    public void createAlarm(@Parameter(description = "알람 생성 요청"
            ,schema = @Schema(implementation = AlarmRequest.AlarmCreateRequest.class))
            @RequestBody AlarmRequest.AlarmCreateRequest alarmCreateRequest) {
        alarmCreateUseCase.createAlarm(alarmCreateRequest);
    }
    @Operation(summary = "알람 조회", tags = {"AlarmController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "알람 조회 성공"),
            @ApiResponse(responseCode = "404", description = "알람 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/alarm/{inventoryId}")
    public AlarmResponse.AlarmInfoResponse getAlarm(@PathVariable Long inventoryId) {
        return alarmGetUseCase.getAlarm(inventoryId);
    }
    @Operation(summary = "알람 수정", tags = {"AlarmController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "알람 수정 성공"),
            @ApiResponse(responseCode = "404", description = "알람 수정 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/alarm/update")
    public void updateAlarm(@Parameter(description = "알람 수정 요청"
            ,schema = @Schema(implementation = AlarmRequest.AlarmUpdateRequest.class))
            @RequestBody AlarmRequest.AlarmUpdateRequest alarmUpdateRequest) {
        alarmUpdateUseCase.updateAlarm(alarmUpdateRequest);
    }

}
