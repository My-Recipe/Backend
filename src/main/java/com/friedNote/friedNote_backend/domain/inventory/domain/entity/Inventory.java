package com.friedNote.friedNote_backend.domain.inventory.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Objects;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    @Builder
    public Inventory(Long id, String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, String sequence, User user) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.registrationDate = registrationDate;
        this.sequence = sequence;
        this.user = user;
    }

    public void updateName(String name) {
        if(name != null&&!Objects.equals(this.name, name)&& StringUtils.hasText(name)) {
            this.name = name;
        }
    }
    public void updateQuantity(String quantity) {
        if(quantity != null&&!Objects.equals(this.quantity, quantity)&& StringUtils.hasText(quantity)) {
            this.quantity = quantity;
        }
    }
    public void updateExpirationDate(LocalDate expirationDate) {
        if(expirationDate != null&&!Objects.equals(this.expirationDate, expirationDate)) {
            this.expirationDate = expirationDate;
        }
    }
    public void updateRegistrationDate(LocalDate registrationDate) {
        if(registrationDate != null&&!Objects.equals(this.registrationDate, registrationDate)) {
            this.registrationDate = registrationDate;
        }
    }
    public void updateSequence(String sequence) {
        if(sequence != null&&!Objects.equals(this.sequence, sequence)&& StringUtils.hasText(sequence)) {
            this.sequence = sequence;
        }
    }
    public void updateInventoryInfo(String name, String quantity, LocalDate expirationDate, LocalDate registrationDate, String sequence) {
        updateName(name);
        updateQuantity(quantity);
        updateExpirationDate(expirationDate);
        updateRegistrationDate(registrationDate);
        updateSequence(sequence);
    }
}
