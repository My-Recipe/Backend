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

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;
import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;

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
            @Parameter(description = "레시피 등록 요청", schema = @Schema(implementation = RecipeRequest.RecipeCreateRequest.class)
    ) @RequestBody RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        recipeCreateUseCase.createRecipe(recipeCreateRequest);
    }

    @Operation(summary = "내가 작성한 레시피 조회", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "내 작성한 레시피 조회 성공"),
            @ApiResponse(responseCode = "404", description = "내 작성한 레시피 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/myPage/my")
    public List<RecipeResponse.RecipeListResponse> getMyRecipeList() {
        return recipeListGetUseCase.getMyRecipeList();
    }

    @Operation(summary = "내가 추가한 모든 레시피 조회", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "내가 추가한 모든 레시피 조회"),
            @ApiResponse(responseCode = "404", description = "내가 추가한 모든 레시피 조회",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/myPage/all")
    public List<RecipeResponse.RecipeListResponse> getMyAllRecipeList() {
        return recipeListGetUseCase.getMyAllRecipeList();
    }

    @Operation(summary = "홈화면 추천레시피 조회", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "홈화면 추천레시피 조회 성공"),
            @ApiResponse(responseCode = "404", description = "홈화면 추천레시피 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/home/recommend")
    public List<RecipeResponse.RecipeMainResponse> getRecommendRecipeList() {
        return recipeMainGetUseCase.getRecommendRecipeList();
    }

    @Operation(summary = "홈화면 레시피 조회", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "홈화면 레시피 조회"),
            @ApiResponse(responseCode = "404", description = "홈화면 레시피 조회",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/home/list")
    public List<RecipeResponse.RecipeListResponse> getHomeRecipeList() {
        return recipeListGetUseCase.getHomeRecipeList();
    }

    @Operation(summary = "레시피 수정", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "레시피 수정 성공"),
            @ApiResponse(responseCode = "404", description = "레시피 수정 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/recipe/update")
    public void updateRecipe(
            @Parameter(description = "레시피 수정 요청", schema = @Schema(implementation = RecipeRequest.RecipeUpdateRequest.class)
    )@ModelAttribute RecipeRequest.RecipeUpdateRequest recipeUpdateRequest) {
        recipeUpdateUseCase.updateRecipe(recipeUpdateRequest);
    }

    @Operation(summary = "레시피 이름 리스트 조회", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "레시피 이름 리스트 조회 성공"),
            @ApiResponse(responseCode = "404", description = "레시피 이름 리스트 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/name")
    public List<RecipeResponse.RecipeNameResponse> getRecipeNameList() {
        return recipeNameListGetUseCase.getRecipeNameList();
    }

    @Operation(summary = "레시피 상세 조회", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "레시피 상세 조회 성공"),
            @ApiResponse(responseCode = "404", description = "레시피 상세 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/{recipeId}")
    public RecipeResponse.RecipeInfoResponse getRecipe(@Parameter(name = "recipeId", description = "레시피 id", in = PATH)
                                                           @PathVariable Long recipeId){
        return recipeGetUseCase.getRecipe(recipeId);
    }

    @Operation(summary = "레시피 이름으로 레시피 검색", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "레시피 이름으로 레시피 검색 성공"),
            @ApiResponse(responseCode = "404", description = "레시피 이름으로 레시피 검색 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/search/name")
    public RecipeResponse.RecipeInfoResponse getRecipeByRecipeName(@Parameter(name="recipeName", description = "레시피 이름", in = QUERY)
                                                                       @RequestParam String recipeName){
        return recipeGetUseCase.getRecipeByRecipeName(recipeName);
    }

    @Operation(summary = "태그로 레시피 검색", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "태그로 레시피 검색 성공"),
            @ApiResponse(responseCode = "404", description = "태그로 레시피 검색 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/search/tag")
    public List<RecipeResponse.RecipeListResponse> getRecipeByTag(
            @Parameter(name="tag1", description = "태그1", in = QUERY) @RequestParam(required = false) String tag1,
            @Parameter(name="tag2", description = "태그2", in = QUERY) @RequestParam(required = false) String tag2,
            @Parameter(name="tag3", description = "태그3", in = QUERY) @RequestParam(required = false) String tag3,
            @Parameter(name="tag4", description = "태그4", in = QUERY) @RequestParam(required = false) String tag4) {
        return recipeListGetUseCase.getRecipeByTag(tag1, tag2, tag3, tag4);
    }

    @Operation(summary = "사용자 식별자로 레시피 조회", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 식별자로 레시피 조회 성공"),
            @ApiResponse(responseCode = "404", description = "사용자 식별자로 레시피 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/list")
    public List<RecipeResponse.RecipeListResponse> getRecipeListByUserId(@Parameter(name="userId", description = "사용자 id", in = QUERY)
                                                                             @RequestParam Long userId) {
        return recipeListGetUseCase.getRecipeListByUserId(userId);
    }

    @Operation(summary = "재료 기반 추천 레시피 조회", tags = {"RecipeController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "재료 기반 추천 레시피 조회 성공"),
            @ApiResponse(responseCode = "404", description = "재료 기반 추천 레시피 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipe/list/ingredient")
    public List<RecipeResponse.RecipeListResponse> getRecommendRecipeListByShortIngredient() {
        return recipeRecommendGetUseCase.getRecommendRecipeListByShortIngredient();
    }
}
