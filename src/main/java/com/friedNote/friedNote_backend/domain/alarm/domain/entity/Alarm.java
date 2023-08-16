package com.friedNote.friedNote_backend.domain.alarm.domain.entity;

import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alarm {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long id;

    private Long deadline;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @Builder
    public Alarm(Long deadline, String email, Inventory inventory) {
        this.deadline = deadline;
        this.email = email;
        this.inventory = inventory;
    }
}
