package com.friedNote.friedNote_backend.domain.recipe.application.mapper;

import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeMapper {

    public static Recipe mapToRecipe(String recipeName, Boolean publicityStatus, RecipeBook recipeBook, User user) {
        return Recipe.builder()
                .recipeName(recipeName)
                .publicityStatus(publicityStatus)
                .recipeBook(recipeBook)
                .user(user)
                .build();
    }
}
