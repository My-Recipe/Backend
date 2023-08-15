package com.myRecipe.myRecipe_backend.domain.recipe.presentation;


import com.myRecipe.myRecipe_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.myRecipe.myRecipe_backend.domain.recipe.application.service.RecipeCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeCreateService recipeCreateService;

    @PostMapping("/recipe")
    public void createRecipe(@RequestBody RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        recipeCreateService.createRecipe(recipeCreateRequest);
    }

}
