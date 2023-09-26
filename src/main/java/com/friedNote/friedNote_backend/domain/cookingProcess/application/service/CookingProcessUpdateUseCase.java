package com.friedNote.friedNote_backend.domain.cookingProcess.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcessImage;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessQueryService;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.s3.S3UploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CookingProcessUpdateUseCase {

    private final CookingProcessQueryService cookingProcessQueryService;
    private final S3UploadService s3UploadService;

    public void updateCookingProcess(CookingProcessRequest.CookingProcessUpdateRequest cookingProcessUpdateRequest) {
        String description = cookingProcessUpdateRequest.getDescription();
        boolean representativeImageStatus = cookingProcessUpdateRequest.isRepresentativeImageStatus();
        String tip = cookingProcessUpdateRequest.getTip();
        Long time = cookingProcessUpdateRequest.getTime();
        Long recipeId = cookingProcessUpdateRequest.getRecipeId();
//        CookingProcessImage cookingProcessImage = (CookingProcessImage) cookingProcessUpdateRequest.getImage();
        //image를 받아와서 cookingProcessImage로 바꿔야 한다.
        MultipartFile image = cookingProcessUpdateRequest.getImage();
        log.info("CookingProcessUpdateUseCase 속 image: {}", image);
        String uploadUrl = s3UploadService.upload(image);
        CookingProcessImage cookingProcessImage = new CookingProcessImage(uploadUrl, representativeImageStatus);

//        log.info("CookingProcess 속 recipeId: {}", recipeId);
        String cookingProcessSequence = cookingProcessUpdateRequest.getCookingProcessSequence();
        Recipe recipe = cookingProcessUpdateRequest.getRecipe();

        List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipeId(recipeId);
        log.info("CookingProcessUpdateUseCase 속 cookingProcessList: {}", cookingProcessList);

        cookingProcessList.forEach(cookingProcess ->{
            cookingProcess.updateTip(tip);
            cookingProcess.updateDescription(description);
            cookingProcess.updateCookingProcessImage(cookingProcessImage);
            cookingProcess.updateTime(time);
            cookingProcess.updateCookingProcessSequence(cookingProcessSequence);
            cookingProcessImage.updateRepresentativeImageStatus(representativeImageStatus);
            cookingProcessImage.updateCookingProcessImage(cookingProcessImage.getImageUrl());
        });

    }
}
