package com.friedNote.friedNote_backend.domain.alarm.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AlarmResponse {

    @Getter
    @NoArgsConstructor
    public static class AlarmInfoResponse {
        private Long deadline;
        private String email;

        @Builder

        public AlarmInfoResponse(Long deadline, String email) {
            this.deadline = deadline;
            this.email = email;
        }
    }
}
