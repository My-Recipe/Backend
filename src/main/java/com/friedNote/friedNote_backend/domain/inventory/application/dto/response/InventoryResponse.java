package com.friedNote.friedNote_backend.domain.inventory.application.dto.response;

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
        @Builder
        public InventoryInfoResponse(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, String sequence) {
            this.name = name;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.registrationDate = registrationDate;
            this.sequence = sequence;
        }
    }
}
