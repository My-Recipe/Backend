package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.domain.cookingProcess.application.mapper.CookingProcessMapper;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessSaveService;
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
    private final CookingProcessSaveService cookingProcessSaveService;

    public void createRecipe(RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        Long recipeBookId = recipeCreateRequest.getRecipeBookId();
        RecipeBook recipeBook = recipeBookQueryService.findById(recipeBookId);

        Long userId = recipeCreateRequest.getUserId();
        User user = userQueryService.findById(userId);

        Recipe recipe = RecipeMapper.mapToRecipe(recipeCreateRequest, recipeBook, user);
        recipeSaveService.saveRecipe(recipe);

        recipeCreateRequest.getCookingProcessCreateRequestList().forEach(cookingProcessCreateRequest -> {
            CookingProcess cookingProcess = CookingProcessMapper.mapToCookingProcess(cookingProcessCreateRequest, recipe);
            cookingProcessSaveService.saveCookingProcess(cookingProcess);
            }
        );
    }
}

