package com.myRecipe.myRecipe_backend.domain.recipe.application.mapper;

import com.myRecipe.myRecipe_backend.domain.recipe.domain.entity.Recipe;
import com.myRecipe.myRecipe_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.myRecipe.myRecipe_backend.domain.user.domain.entity.User;
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
