package com.friedNote.friedNote_backend.domain.recipeBook.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.common.util.UserUtils;
import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.friedNote.friedNote_backend.domain.recipeBook.application.mapper.RecipeBookMapper;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.service.RecipeBookSaveService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RecipeBookCreateUseCase {

    private final RecipeBookSaveService recipeBookSaveService;
    private final UserUtils userUtils;

    public void createRecipeBook(RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {
        String title = recipeBookCreateRequest.getTitle();
        String subtitle = recipeBookCreateRequest.getSubtitle();
        Long userId = recipeBookCreateRequest.getUserId();
        User user = userUtils.getUser();
        boolean publicityStatus = recipeBookCreateRequest.isPublicityStatus();

        RecipeBook recipeBook = RecipeBookMapper.mapToRecipeBook(title, subtitle, user, publicityStatus);
        recipeBookSaveService.saveRecipeBook(recipeBook);

    }
}
