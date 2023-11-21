package com.friedNote.friedNote_backend.domain.alarm.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AlarmResponse {

    @Getter
    @NoArgsConstructor
    public static class AlarmInfoResponse {
        @Schema(description = "기한", defaultValue = "deadline")
        private Long deadline;
        @Schema(description = "이메일", defaultValue = "email")
        private String email;

        @Builder
        public AlarmInfoResponse(Long deadline, String email) {
            this.deadline = deadline;
            this.email = email;
        }
    }
}
