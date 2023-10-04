package com.friedNote.friedNote_backend.domain.recipe.application.mapper;

import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.response.CookingProcessResponse;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.response.IngredientGroupResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeMapper {

    public static Recipe mapToRecipe(RecipeRequest.RecipeCreateRequest recipeCreateRequest, RecipeBook recipeBook, User user) {
        return Recipe.builder()
                .recipeName(recipeCreateRequest.getRecipeName())
                .publicityStatus(recipeCreateRequest.isPublicityStatus())
                .recipeBook(recipeBook)
                .user(user)
                .build();
    }

    public static RecipeResponse.RecipeListResponse mapToRecipeAllResponse(Recipe recipe, String imageUrl,
                                                                          String description, boolean bookmark) {
        return RecipeResponse.RecipeListResponse.builder()
                .recipeId(recipe.getId())
                .recipeName(recipe.getRecipeName())
                .userName(recipe.getUser().getName())
                .imageUrl(imageUrl)
                .description(description)
                .bookmark(bookmark)
                .build();
    }

    public static RecipeResponse.RecipeInfoResponse mapToRecipeInfoResponse(Recipe recipe, List<IngredientGroupResponse.IngredientGroupInfoResponse> ingredientGroupList,
                                                                            List<CookingProcessResponse.CookingProcessInfoResponse> cookingProcessList) {
        return RecipeResponse.RecipeInfoResponse.builder()
                .bookTitle(recipe.getRecipeBook().getTitle())
                .userName(recipe.getUser().getName())
                .recipeName(recipe.getRecipeName())
                .ingredientGroupList(ingredientGroupList)
                .cookingProcessList(cookingProcessList)
                .build();
    }

    public static RecipeResponse.RecipeNameResponse mapToRecipeNameResponse(Recipe recipe) {
        return RecipeResponse.RecipeNameResponse.builder()
                .recipeName(recipe.getRecipeName())
                .build();
    }
}
