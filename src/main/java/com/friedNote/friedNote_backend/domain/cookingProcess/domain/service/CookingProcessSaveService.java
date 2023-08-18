package com.friedNote.friedNote_backend.domain.cookingProcess.domain.service;

import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.repository.CookingProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CookingProcessSaveService {

    private final CookingProcessRepository cookingProcessRepository;

    public void saveCookingProcess(CookingProcess cookingProcess) {
        cookingProcessRepository.save(cookingProcess);
    }
}
