package com.friedNote.friedNote_backend.domain.recipe.presentation;


import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.service.RecipeCreateUseCase;
import com.friedNote.friedNote_backend.domain.recipe.application.service.RecipeListGetUseCase;
import com.friedNote.friedNote_backend.domain.recipe.application.service.RecipeMainGetUseCase;
import com.friedNote.friedNote_backend.domain.recipe.application.service.RecipeUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RecipeController {

    private final RecipeCreateUseCase recipeCreateUseCase;
    private final RecipeListGetUseCase recipeListGetUseCase;
    private final RecipeMainGetUseCase recipeMainGetUseCase;
    private final RecipeUpdateUseCase recipeUpdateUseCase;

    @PostMapping("/recipe")
    public void createRecipe(@ModelAttribute RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        recipeCreateUseCase.createRecipe(recipeCreateRequest);
    }

    @GetMapping("/recipe/{userId}")
    public List<RecipeResponse.RecipeListResponse> getMyRecipeList(@PathVariable Long userId) {
        return recipeListGetUseCase.getMyRecipeList(userId);
    }

    @GetMapping("/recipe/all/{userId}")
    public List<RecipeResponse.RecipeListResponse> getMyAllRecipeList(@PathVariable Long userId) {
        return recipeListGetUseCase.getMyAllRecipeList(userId);
    }

    @GetMapping("/home/recommend")
    public List<RecipeResponse.RecipeMainResponse> getRecommendRecipeList() {
        return recipeMainGetUseCase.getRecommendRecipeList();
    }

    @GetMapping("/home/recipe")
    public List<RecipeResponse.RecipeListResponse> getHomeRecipeList() {
        return recipeListGetUseCase.getHomeRecipeList();
    }

    @PostMapping("/recipe/update")
    public void updateRecipe(@ModelAttribute RecipeRequest.RecipeUpdateRequest recipeUpdateRequest) {
        log.info("recipeUpdateRequest: {}", recipeUpdateRequest);
        recipeUpdateUseCase.updateRecipe(recipeUpdateRequest);
    }

}
