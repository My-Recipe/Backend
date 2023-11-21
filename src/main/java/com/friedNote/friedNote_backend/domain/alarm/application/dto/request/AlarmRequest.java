package com.friedNote.friedNote_backend.domain.alarm.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AlarmRequest {
    @Getter
    @NoArgsConstructor
    public static class AlarmCreateRequest {
        @Schema(description = "기한", defaultValue = "deadline")
        private Long deadline;
        @Schema(description = "이메일", defaultValue = "email")
        private String email;
        @Schema(description = "인벤토리 아이디", defaultValue = "inventoryId")
        private Long inventoryId;

        @Builder
        public AlarmCreateRequest(Long deadline, String email, Long inventoryId) {
            this.deadline = deadline;
            this.email = email;
            this.inventoryId = inventoryId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class AlarmUpdateRequest {
        @Schema(description = "기한", defaultValue = "deadline")
        private Long deadline;
        @Schema(description = "이메일", defaultValue = "email")
        private String email;
        @Schema(description = "인벤토리 아이디", defaultValue = "inventoryId")
        private Long inventoryId;
        @Schema(description = "알람 아이디", defaultValue = "alarmId")
        private Long alarmId;

        @Builder
        public AlarmUpdateRequest(Long deadline, String email, Long inventoryId, Long alarmId) {
            this.deadline = deadline;
            this.email = email;
            this.inventoryId = inventoryId;
            this.alarmId = alarmId;
        }
    }
}
