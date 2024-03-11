package com.friedNote.friedNote_backend.domain.recipeBook.application.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.common.util.UserUtils;
import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.service.RecipeBookQueryService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class RecipeBookUpdateUseCase {

    private final RecipeBookQueryService recipeBookQueryService;
    private final UserUtils userUtils;

    public void updateRecipeBook(RecipeBookRequest.RecipeBookUpdateRequest recipeBookUpdateRequest) {

        User user = userUtils.getUser();
        String title = recipeBookUpdateRequest.getTitle();
        String subtitle = recipeBookUpdateRequest.getSubtitle();
        boolean publicityStatus = recipeBookUpdateRequest.isPublicityStatus();
        RecipeBook recipeBook = recipeBookQueryService.findByUserId(user.getId());
        recipeBook.updateRecipeBookInfo(title, subtitle, publicityStatus);
    }

}
