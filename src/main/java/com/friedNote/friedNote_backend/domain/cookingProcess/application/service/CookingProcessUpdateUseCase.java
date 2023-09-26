package com.friedNote.friedNote_backend.domain.cookingProcess.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcessImage;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessQueryService;
import com.friedNote.friedNote_backend.domain.s3.S3UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class CookingProcessUpdateUseCase {

    private final CookingProcessQueryService cookingProcessQueryService;
    private final S3UploadService s3UploadService;

    public void updateCookingProcess(CookingProcessRequest.CookingProcessUpdateRequest cookingProcessUpdateRequest) {
        String description = cookingProcessUpdateRequest.getDescription();
        boolean representativeImageStatus = cookingProcessUpdateRequest.isRepresentativeImageStatus();
        String tip = cookingProcessUpdateRequest.getTip();
        Long time = cookingProcessUpdateRequest.getTime();
        Long recipeId = cookingProcessUpdateRequest.getRecipeId();
        MultipartFile image = cookingProcessUpdateRequest.getImage();
        String uploadUrl = s3UploadService.upload(image);
        CookingProcessImage cookingProcessImage = new CookingProcessImage(uploadUrl, representativeImageStatus);
        String cookingProcessSequence = cookingProcessUpdateRequest.getCookingProcessSequence();

        List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipeId(recipeId);

        cookingProcessList.forEach(cookingProcess ->{
            cookingProcess.updateCookingProcessInfo(cookingProcessSequence, description, cookingProcessImage, tip, time);
            cookingProcessImage.updateCookingProcessImageInfo(cookingProcessImage.getImageUrl(), cookingProcessImage.isRepresentativeImageStatus());
        });

    }
}
