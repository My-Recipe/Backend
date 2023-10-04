package com.friedNote.friedNote_backend.domain.recipe.presentation;


import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.service.*;
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
    private final RecipeNameListGetUseCase recipeNameListGetUseCase;
    private final RecipeGetUseCase recipeGetUseCase;

    @PostMapping("/recipe")
    public void createRecipe(@ModelAttribute RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        recipeCreateUseCase.createRecipe(recipeCreateRequest);
    }

    @GetMapping("/myPage/recipe/my")
    public List<RecipeResponse.RecipeListResponse> getMyRecipeList() {
        return recipeListGetUseCase.getMyRecipeList();
    }

    @GetMapping("/myPage/recipe/all")
    public List<RecipeResponse.RecipeListResponse> getMyAllRecipeList() {
        return recipeListGetUseCase.getMyAllRecipeList();
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

    @GetMapping("/recipe/name")
    public List<RecipeResponse.RecipeNameResponse> getRecipeNameList() {
        return recipeNameListGetUseCase.getRecipeNameList();
    }

    @GetMapping("/recipe/{recipeId}")
    public RecipeResponse.RecipeInfoResponse getRecipe(@PathVariable Long recipeId){
        return recipeGetUseCase.getRecipe(recipeId);
    }

    @GetMapping("/search/recipe/name")
    public RecipeResponse.RecipeInfoResponse getRecipeByRecipeName(@RequestParam String recipeName){
        return recipeGetUseCase.getRecipeByRecipeName(recipeName);
    }


}
