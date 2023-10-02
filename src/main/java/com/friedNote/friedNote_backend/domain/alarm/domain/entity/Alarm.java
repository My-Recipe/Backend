package com.friedNote.friedNote_backend.domain.alarm.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alarm extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long id;

    private Long deadline;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    @JsonIgnore
    private Inventory inventory;

    @Builder
    public Alarm(Long deadline, String email, Inventory inventory) {
        this.deadline = deadline;
        this.email = email;
        this.inventory = inventory;
    }

    public void updateDeadline(Long deadline) {
        if(deadline != null && !Objects.equals(this.deadline, deadline)) {
            this.deadline = deadline;
        }
    }
    public void updateEmail(String email) {
        if(email != null && !Objects.equals(this.email, email) && StringUtils.hasText(email)) {
            this.email = email;
        }
    }
    public void updateAlarm(Long deadline, String email) {
        updateDeadline(deadline);
        updateEmail(email);
    }
}
