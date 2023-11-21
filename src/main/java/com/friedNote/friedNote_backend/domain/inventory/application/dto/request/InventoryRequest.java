package com.friedNote.friedNote_backend.domain.inventory.application.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class InventoryRequest {
    @Getter
    @NoArgsConstructor
    public static class InventoryCreateRequest {
        @Schema(description = "재료 이름", defaultValue = "name")
        private String name;
        @Schema(description = "재료 수량", defaultValue = "quantity")
        private String quantity;
        @Schema(description = "유통기한", defaultValue = "expirationDate")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate expirationDate;
        @Schema(description = "등록일자", defaultValue = "registrationDate")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate registrationDate;
        @Schema(description = "사용자 식별자", defaultValue = "userId")
        private Long userId;

        @Builder
        public InventoryCreateRequest(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, Long userId) {
            this.name = name;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.registrationDate = registrationDate;
            this.userId = userId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class InventoryUpdateRequest {
        @Schema(description = "재료 이름", defaultValue = "name")
        private String name;
        @Schema(description = "재료 수량", defaultValue = "quantity")
        private String quantity;
        @Schema(description = "유통기한", defaultValue = "expirationDate")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate expirationDate;
        @Schema(description = "등록일자", defaultValue = "registrationDate")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate registrationDate;
        @Schema(description = "인벤토리 식별자", defaultValue = "inventoryId")
        private Long inventoryId;
        @Builder
        public InventoryUpdateRequest(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, Long inventoryId) {
            this.name = name;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.registrationDate = registrationDate;
            this.inventoryId = inventoryId;
        }
    }

}
