package com.friedNote.friedNote_backend.domain.recipe.application.mapper;

import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
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
