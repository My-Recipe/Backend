package com.myRecipe.myRecipe_backend.domain.inventory.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inventory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;

    private String name; //not null
    private String quantity;
    private LocalDate expirationDate;
    private LocalDate registrationDate;

    @Builder
    public Inventory(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.registrationDate = registrationDate;
    }
}
