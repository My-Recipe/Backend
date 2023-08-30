package com.friedNote.friedNote_backend.domain.recipeBook.presentation;

import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.friedNote.friedNote_backend.domain.recipeBook.application.service.RecipeBookCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecipeBookController {

    private final RecipeBookCreateUseCase recipeBookCreateUseCase;

    @PostMapping("/recipeBook")
    public void createRecipeBook(@RequestBody RecipeBookRequest.RecipeBookCreateRequest recipeBookCreateRequest) {
        recipeBookCreateUseCase.createRecipeBook(recipeBookCreateRequest);
    }
}
