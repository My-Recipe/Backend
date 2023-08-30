package com.friedNote.friedNote_backend.domain.recipe.presentation;


import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.service.RecipeCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeCreateService recipeCreateService;

    @PostMapping("/recipe")
    public void createRecipe(@ModelAttribute RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        recipeCreateService.createRecipe(recipeCreateRequest);
    }
}
