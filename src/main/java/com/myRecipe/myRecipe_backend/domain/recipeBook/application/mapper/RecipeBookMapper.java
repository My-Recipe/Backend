package com.myRecipe.myRecipe_backend.domain.recipeBook.application.mapper;

import com.myRecipe.myRecipe_backend.domain.recipeBook.application.dto.request.RecipeBookRequest;
import com.myRecipe.myRecipe_backend.domain.recipeBook.domain.entity.RecipeBook;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeBookMapper {
    public static RecipeBook mapToRecipeBook(String title, String subtitle) {
        return RecipeBook.builder()
                .title(title)
                .subtitle(subtitle)
                .build();
    }
}
