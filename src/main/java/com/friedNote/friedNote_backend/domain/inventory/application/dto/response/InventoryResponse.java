package com.friedNote.friedNote_backend.domain.inventory.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class InventoryResponse {
    @Getter
    @NoArgsConstructor
    public static class InventoryInfoResponse {
        @Schema(description = "재료 이름", defaultValue = "name")
        private String name;
        @Schema(description = "재료 수량", defaultValue = "quantity")
        private String quantity;
        @Schema(description = "유통기한", defaultValue = "expirationDate")
        private LocalDate expirationDate;
        @Schema(description = "등록일자", defaultValue = "registrationDate")
        private LocalDate registrationDate;
        @Builder
        public InventoryInfoResponse(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate) {
            this.name = name;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.registrationDate = registrationDate;
        }
    }
    @Getter
    @NoArgsConstructor
    public static class InventoryTagInfoResponse {
        @Schema(description = "태그 이름", defaultValue = "name")
        private String name;
        @Builder
        public InventoryTagInfoResponse(String name) {
            this.name = name;
        }
    }
}
