package com.myRecipe.myRecipe_backend.domain.recipe.application.service;

import com.myRecipe.myRecipe_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.myRecipe.myRecipe_backend.domain.recipe.application.mapper.RecipeMapper;
import com.myRecipe.myRecipe_backend.domain.recipe.domain.entity.Recipe;
import com.myRecipe.myRecipe_backend.domain.recipe.domain.service.RecipeSaveService;
import com.myRecipe.myRecipe_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.myRecipe.myRecipe_backend.domain.recipeBook.domain.service.RecipeBookQueryService;
import com.myRecipe.myRecipe_backend.domain.user.domain.entity.User;
import com.myRecipe.myRecipe_backend.domain.user.domain.service.UserQueryService;
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

