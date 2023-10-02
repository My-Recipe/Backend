package com.friedNote.friedNote_backend.domain.alarm.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AlarmRequest {
    @Getter
    @NoArgsConstructor
    public static class AlarmCreateRequest {
        private Long deadline;
        private String email;
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
        private Long deadline;
        private String email;
        private Long inventoryId;

        @Builder
        public AlarmUpdateRequest(Long deadline, String email, Long inventoryId) {
            this.deadline = deadline;
            this.email = email;
            this.inventoryId = inventoryId;
        }
    }
}
