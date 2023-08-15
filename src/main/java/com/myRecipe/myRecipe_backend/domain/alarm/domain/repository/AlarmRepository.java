package com.myRecipe.myRecipe_backend.domain.alarm.domain.repository;

import com.myRecipe.myRecipe_backend.domain.alarm.domain.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}
