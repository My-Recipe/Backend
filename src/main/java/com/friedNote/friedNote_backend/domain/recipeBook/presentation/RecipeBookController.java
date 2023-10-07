package com.friedNote.friedNote_backend.domain.recipeBook.presentation;

import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.response.RecipeBookResponse;
import com.friedNote.friedNote_backend.domain.recipeBook.application.service.RecipeBookCreateUseCase;
import com.friedNote.friedNote_backend.domain.recipeBook.application.service.RecipeBookGetUseCase;
import com.friedNote.friedNote_backend.domain.recipeBook.application.service.RecipeBookUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RecipeBookController {

    private final RecipeBookCreateUseCase recipeBookCreateUseCase;
    private final RecipeBookUpdateUseCase recipeBookUpdateUseCase;
    private final RecipeBookGetUseCase recipeBookGetUseCase;

    @PostMapping("/recipeBook")
    public void createRecipeBook(@RequestBody RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {
        recipeBookCreateUseCase.createRecipeBook(recipeBookCreateRequest);
    }

    @PostMapping("/recipeBook/update")
    public void updateRecipeBook(@RequestBody RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {
        recipeBookUpdateUseCase.updateRecipeBook(recipeBookCreateRequest);
    }
    @GetMapping("/recipeBook")
    public RecipeBookResponse.RecipeBookInfoResponse getRecipeBookInfo() {
        return recipeBookGetUseCase.getRecipeBookInfo();
    }
    @GetMapping("/recipeBook/{userId}/otherRecipeBook")
    public RecipeBookResponse.RecipeBookInfoResponse getOtherRecipeBookInfo(@PathVariable Long userId) {
        return recipeBookGetUseCase.getOtherRecipeBookInfo(userId);
    }
}
