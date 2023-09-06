package com.friedNote.friedNote_backend.domain.cookingProcess.application.mapper;

import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcessImage;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CookingProcessMapper {

    public static CookingProcess mapToCookingProcess(CookingProcessRequest.CookingProcessCreateRequest
                                                             cookingProcessCreateRequest, Recipe recipe, String imageUrl) {
        CookingProcessImage cookingProcessImage = new CookingProcessImage(imageUrl,
                cookingProcessCreateRequest.isRepresentativeImageStatus());
        return CookingProcess.builder()
                .cookingProcessSequence(cookingProcessCreateRequest.getCookingProcessSequence())
                .description(cookingProcessCreateRequest.getDescription())
                .cookingProcessImage(cookingProcessImage)
                .tip(cookingProcessCreateRequest.getTip())
                .time(cookingProcessCreateRequest.getTime())
                .recipe(recipe)
                .build();
    }
}
