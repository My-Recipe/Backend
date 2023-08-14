package com.myRecipe.myRecipe_backend.domain.recipeBook.presentation;

import com.myRecipe.myRecipe_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.myRecipe.myRecipe_backend.domain.recipeBook.application.service.RecipeBookCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecipeBookController {

    private final RecipeBookCreateService recipeBookCreateService;

    @PostMapping("/recipeBook")
    public void createRecipeBook(@RequestBody RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {
        recipeBookCreateService.createRecipeBook(recipeBookCreateRequest);
    }
}
