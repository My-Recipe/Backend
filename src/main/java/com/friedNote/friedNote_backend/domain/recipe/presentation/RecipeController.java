package com.friedNote.friedNote_backend.domain.recipe.presentation;


import com.friedNote.friedNote_backend.common.exception.dto.ErrorResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    private final RecipeRecommendGetUseCase recipeRecommendGetUseCase;


    @Operation(summary = "레시피 등록", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "레시피 등록 성공"),
            @ApiResponse(responseCode = "404", description = "레시피 등록 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/recipe")
    public void createRecipe(
            @Parameter( description = "레시피 등록 요청", schema = @Schema(implementation = RecipeRequest.RecipeCreateRequest.class)
    ) @ModelAttribute RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
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

    @GetMapping("/search/recipe/tag")
    public List<RecipeResponse.RecipeListResponse> getRecipeByTag(@RequestParam(required = false) String tag1, @RequestParam(required = false) String tag2,
                                                                  @RequestParam(required = false) String tag3, @RequestParam(required = false) String tag4) {
        log.info("호출");
        return recipeListGetUseCase.getRecipeByTag(tag1, tag2, tag3, tag4);
    }

    @GetMapping("/recipe/list")
    public List<RecipeResponse.RecipeListResponse> getRecipeListByUserId(@RequestParam Long userId) {
        return recipeListGetUseCase.getRecipeListByUserId(userId);
    }
    @GetMapping("/recipe/list/ingredient")
    public List<RecipeResponse.RecipeListResponse> getRecommendRecipeListByShortIngredient() {
        return recipeRecommendGetUseCase.getRecommendRecipeListByShortIngredient();
    }
}
