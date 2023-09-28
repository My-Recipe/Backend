package com.friedNote.friedNote_backend.domain.inventory.application.dto.response;

import com.friedNote.friedNote_backend.domain.alarm.domain.entity.Alarm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class InventoryResponse {
    @Getter
    @NoArgsConstructor
    public static class InventoryInfoResponse {
        private String name;
        private String quantity;
        private LocalDate expirationDate;
        private LocalDate registrationDate;
        private String sequence;
        private Alarm alarm;
        @Builder
        public InventoryInfoResponse(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, String sequence, Alarm alarm) {
            this.name = name;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.registrationDate = registrationDate;
            this.sequence = sequence;
            this.alarm = alarm;
        }
    }
}
