package com.myRecipe.myRecipe_backend.domain.recipeBook.application.service;

import com.myRecipe.myRecipe_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.myRecipe.myRecipe_backend.domain.recipeBook.application.mapper.RecipeBookMapper;
import com.myRecipe.myRecipe_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.myRecipe.myRecipe_backend.domain.recipeBook.domain.service.RecipeBookSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeBookCreateService {

    private final RecipeBookSaveService recipeBookSaveService;

    public void createRecipeBook(RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {
        String title = recipeBookCreateRequest.getTitle();
        String subtitle = recipeBookCreateRequest.getSubtitle();
        RecipeBook recipeBook = RecipeBookMapper.mapToRecipeBook(title, subtitle);
        recipeBookSaveService.saveRecipeBook(recipeBook);

    }
}
