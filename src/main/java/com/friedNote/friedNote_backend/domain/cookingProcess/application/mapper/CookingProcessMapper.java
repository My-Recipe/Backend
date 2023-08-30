package com.friedNote.friedNote_backend.domain.cookingProcess.application.mapper;

import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.request.CookingProcessRequest;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CookingProcessMapper {

    public static CookingProcess mapToCookingProcess(CookingProcessRequest.CookingProcessCreateRequest
                                                             cookingProcessCreateRequest, Recipe recipe, String imageUrl) {
        return CookingProcess.builder()
                .description(cookingProcessCreateRequest.getDescription())
                .imageUrl(imageUrl)
                .tip(cookingProcessCreateRequest.getTip())
                .time(cookingProcessCreateRequest.getTime())
                .recipe(recipe)
                .build();
    }
}
