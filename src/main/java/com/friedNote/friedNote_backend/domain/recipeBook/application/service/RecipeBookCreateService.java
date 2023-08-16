package com.friedNote.friedNote_backend.domain.recipeBook.application.service;

import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.friedNote.friedNote_backend.domain.recipeBook.application.mapper.RecipeBookMapper;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.service.RecipeBookSaveService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeBookCreateService {

    private final RecipeBookSaveService recipeBookSaveService;

    private final UserQueryService userQueryService;

    public void createRecipeBook(RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {
        String title = recipeBookCreateRequest.getTitle();
        String subtitle = recipeBookCreateRequest.getSubtitle();
        Long userId = recipeBookCreateRequest.getUserId();
        User user = userQueryService.findById(userId);

        RecipeBook recipeBook = RecipeBookMapper.mapToRecipeBook(title, subtitle,user);
        recipeBookSaveService.saveRecipeBook(recipeBook);

    }
}
