package com.myRecipe.myRecipe_backend.domain.alarm.application.mapper;

import com.myRecipe.myRecipe_backend.domain.alarm.domain.entity.Alarm;
import com.myRecipe.myRecipe_backend.domain.inventory.domain.entity.Inventory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class AlarmMapper {

    public static Alarm mapToAlarm(Long deadline, String email, Inventory inventory) {
        return Alarm.builder()
                .deadline(deadline)
                .email(email)
                .inventory(inventory)
                .build();
    }
}
