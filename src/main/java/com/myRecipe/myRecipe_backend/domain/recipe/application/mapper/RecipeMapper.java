package com.myRecipe.myRecipe_backend.domain.recipe.application.mapper;

import com.myRecipe.myRecipe_backend.domain.recipe.domain.entity.Recipe;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeMapper {

    public static Recipe mapToRecipe(String recipeName, Boolean publicityStatus) {
        return Recipe.builder()
                .recipeName(recipeName)
                .publicityStatus(publicityStatus)
                .build();
    }
}
