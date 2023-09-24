package com.friedNote.friedNote_backend.domain.cookingProcess.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcessImage;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class CookingProcessUpdateUseCase {

    private final CookingProcessQueryService cookingProcessQueryService;

    public void updateCookingProcess(CookingProcessRequest.CookingProcessUpdateRequest cookingProcessUpdateRequest) {
        String description = cookingProcessUpdateRequest.getDescription();
        boolean representativeImageStatus = cookingProcessUpdateRequest.isRepresentativeImageStatus();
        String tip = cookingProcessUpdateRequest.getTip();
        Long time = cookingProcessUpdateRequest.getTime();
        Long cookingProcessId = cookingProcessUpdateRequest.getCookingProcessId();
        CookingProcessImage cookingProcessImage = cookingProcessUpdateRequest.getCookingProcessImage();
        String cookingProcessSequence = cookingProcessUpdateRequest.getCookingProcessSequence();

        CookingProcess cookingProcess = cookingProcessQueryService.findCookingProcessById(cookingProcessId);
        cookingProcess.updateTip(tip);
        cookingProcess.updateDescription(description);
        cookingProcess.updateCookingProcessImage(cookingProcessImage);
        cookingProcess.updateTime(time);
        cookingProcess.updateCookingProcessSequence(cookingProcessSequence);
        cookingProcessImage.updateRepresentativeImageStatus(representativeImageStatus);
    }
}
