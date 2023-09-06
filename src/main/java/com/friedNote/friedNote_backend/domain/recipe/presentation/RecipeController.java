package com.friedNote.friedNote_backend.domain.recipe.presentation;


import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.service.RecipeCreateUseCase;
import com.friedNote.friedNote_backend.domain.recipe.application.service.RecipeGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeCreateUseCase recipeCreateUseCase;
    private final RecipeGetUseCase recipeGetUseCase;

    @PostMapping("/recipe")
    public void createRecipe(@ModelAttribute RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        recipeCreateUseCase.createRecipe(recipeCreateRequest);
    }

    @GetMapping("/recipe/{userId}")
    public List<RecipeResponse.RecipeListResponse> getMyRecipeList(@PathVariable Long userId) {
        return recipeGetUseCase.getMyRecipeList(userId);
    }

//    @GetMapping("/recipe/all/{userId}")
//    public List<RecipeResponse.RecipeListResponse> getMyAllRecipeList(@PathVariable Long userId) {
//        return recipeGetUseCase.getMyAllRecipeList(userId);
//    }


}
