package com.friedNote.friedNote_backend.domain.inventory.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inventory extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;

    private String name; //not null
    private String quantity;
    private LocalDate expirationDate;
    private LocalDate registrationDate;
    private String sequence;

    @Builder
    public Inventory(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, String sequence) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.registrationDate = registrationDate;
        this.sequence = sequence;
    }
}
