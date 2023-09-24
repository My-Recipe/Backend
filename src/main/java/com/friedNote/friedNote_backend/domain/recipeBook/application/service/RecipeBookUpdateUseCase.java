package com.friedNote.friedNote_backend.domain.recipeBook.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.service.RecipeBookQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RecipeBookUpdateUseCase {

    private final RecipeBookQueryService recipeBookQueryService;

    @Transactional
    public void updateRecipeBook(RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {

        String title = recipeBookCreateRequest.getTitle();
        String subtitle = recipeBookCreateRequest.getSubtitle();
        boolean publicityStatus = recipeBookCreateRequest.isPublicityStatus();

        RecipeBook recipeBook = recipeBookQueryService.findByUserId(recipeBookCreateRequest.getUserId());
        recipeBook.updateRecipeBookTitle(title);
        recipeBook.updateRecipeBookSubtitle(subtitle);
        recipeBook.updateRecipeBookPublicityStatus(publicityStatus);
    }

}
