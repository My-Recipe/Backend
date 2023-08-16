package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.mapper.RecipeMapper;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeSaveService;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.service.RecipeBookQueryService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeCreateService {

    private final RecipeSaveService recipeSaveService;

    private final RecipeBookQueryService recipeBookQueryService;

    private final UserQueryService userQueryService;

    public void createRecipe(RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        String dishName = recipeCreateRequest.getRecipeName();
        boolean publicityStatus = recipeCreateRequest.isPublicityStatus();

        Long recipeBookId = recipeCreateRequest.getRecipeBookId();
        RecipeBook recipeBook = recipeBookQueryService.findById(recipeBookId);

        Long userId = recipeCreateRequest.getUserId();
        User user = userQueryService.findById(userId);

        Recipe recipe = RecipeMapper.mapToRecipe(dishName, publicityStatus, recipeBook, user);

        recipeSaveService.saveRecipe(recipe);
    }

}

