package com.friedNote.friedNote_backend.domain.cookingProcess.domain.repository;

import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookingProcessRepository extends JpaRepository<CookingProcess, Long> {
}
