package com.myRecipe.myRecipe_backend.domain.recipe.application.mapper;

import com.myRecipe.myRecipe_backend.domain.recipe.domain.entity.Recipe;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeMapper {

    public static Recipe mapToRecipe(String dishName, Boolean publicityStatus) {
        return Recipe.builder()
                .dishName(dishName)
                .publicityStatus(publicityStatus)
                .build();
    }
}
