package com.friedNote.friedNote_backend.domain.recipeBook.presentation;

import com.friedNote.friedNote_backend.common.exception.dto.ErrorResponse;
import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.response.RecipeBookResponse;
import com.friedNote.friedNote_backend.domain.recipeBook.application.service.RecipeBookCreateUseCase;
import com.friedNote.friedNote_backend.domain.recipeBook.application.service.RecipeBookGetUseCase;
import com.friedNote.friedNote_backend.domain.recipeBook.application.service.RecipeBookUpdateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RecipeBookController {

    private final RecipeBookCreateUseCase recipeBookCreateUseCase;
    private final RecipeBookUpdateUseCase recipeBookUpdateUseCase;
    private final RecipeBookGetUseCase recipeBookGetUseCase;

    @Operation(summary = "레시피북 생성", tags = {"RecipeBookController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "레시피북 생성 성공"),
            @ApiResponse(responseCode = "404", description = "레시피북 생성 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/recipeBook")
    public void createRecipeBook(@RequestBody RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {
        recipeBookCreateUseCase.createRecipeBook(recipeBookCreateRequest);
    }

    @Operation(summary = "레시피북 수정", tags = {"RecipeBookController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "레시피북 수정 성공"),
            @ApiResponse(responseCode = "404", description = "레시피북 수정 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/recipeBook/update")
    public void updateRecipeBook(@RequestBody RecipeBookRequest.RecipeBookUpdateRequest recipeBookUpdateRequest) {
        recipeBookUpdateUseCase.updateRecipeBook(recipeBookUpdateRequest);
    }
    @Operation(summary = "본인 레시피북 조회", tags = {"RecipeBookController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "레시피북 조회 성공"),
            @ApiResponse(responseCode = "404", description = "레시피북 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipeBook")
    public RecipeBookResponse.RecipeBookInfoResponse getRecipeBookInfo() {
        return recipeBookGetUseCase.getRecipeBookInfo();
    }
    @Operation(summary = "다른 사람 레시피북 조회", tags = {"RecipeBookController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "다른 사람 레시피북 조회 성공"),
            @ApiResponse(responseCode = "404", description = "다른 사람 레시피북 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/recipeBook/otherRecipeBook/{userId}")
    public RecipeBookResponse.RecipeBookInfoResponse getOtherRecipeBookInfo(@PathVariable Long userId) {
        return recipeBookGetUseCase.getOtherRecipeBookInfo(userId);
    }
}
