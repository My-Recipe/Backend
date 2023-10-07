package com.friedNote.friedNote_backend.domain.recipeBook.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.common.util.UserUtils;
import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.response.RecipeBookResponse;
import com.friedNote.friedNote_backend.domain.recipeBook.application.mapper.RecipeBookMapper;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.service.RecipeBookQueryService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RecipeBookGetUseCase {

    private final RecipeBookQueryService recipeBookQueryService;
    private final UserUtils userUtils;

    public RecipeBookResponse.RecipeBookInfoResponse getRecipeBookInfo() {
        User user = userUtils.getUser();
        Long userId = user.getId();
        RecipeBook recipeBook = recipeBookQueryService.findByUserId(userId);
        RecipeBookResponse.RecipeBookInfoResponse recipeBookInfoResponse
                = RecipeBookMapper.mapToRecipeBookInfo(recipeBook);

        return recipeBookInfoResponse;
    }

    public RecipeBookResponse.RecipeBookInfoResponse getOtherRecipeBookInfo(Long userId) {
        RecipeBook recipeBook = recipeBookQueryService.findByUserId(userId);
        RecipeBookResponse.RecipeBookInfoResponse recipeBookInfoResponse
                = RecipeBookMapper.mapToRecipeBookInfo(recipeBook);

        return recipeBookInfoResponse;
    }
}
