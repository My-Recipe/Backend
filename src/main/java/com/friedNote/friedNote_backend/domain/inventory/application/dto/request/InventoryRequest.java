package com.friedNote.friedNote_backend.domain.inventory.application.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class InventoryRequest {
    @Getter
    @NoArgsConstructor
    public static class InventoryCreateRequest {

        private String name;
        private String quantity;

        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate expirationDate;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate registrationDate;
        private String sequence;
        private Long userId;

        @Builder
        public InventoryCreateRequest(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, String sequence, Long userId) {
            this.name = name;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.registrationDate = registrationDate;
            this.sequence = sequence;
            this.userId = userId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class InventoryUpdateRequest {
        private String name;
        private String quantity;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate expirationDate;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate registrationDate;
        private String sequence;
        private Long inventoryId;
        @Builder
        public InventoryUpdateRequest(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, String sequence, Long inventoryId) {
            this.name = name;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.registrationDate = registrationDate;
            this.sequence = sequence;
            this.inventoryId = inventoryId;
        }
    }

}
