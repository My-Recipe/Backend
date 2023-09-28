package com.friedNote.friedNote_backend.domain.alarm.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AlarmResponse {

    @Getter
    @NoArgsConstructor
    public static class AlarmInfoResponse {
        private Long alarmId;
        private Long deadline;
        private String email;
        private Long inventoryId;

        @Builder
        public AlarmInfoResponse(Long alarmId, Long deadline, String email, Long inventoryId) {
            this.alarmId = alarmId;
            this.deadline = deadline;
            this.email = email;
            this.inventoryId = inventoryId;
        }
    }
}
