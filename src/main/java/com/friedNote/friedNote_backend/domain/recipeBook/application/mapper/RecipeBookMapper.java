package com.friedNote.friedNote_backend.domain.recipeBook.application.mapper;

import com.friedNote.friedNote_backend.domain.recipeBook.application.dto.response.RecipeBookResponse;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeBookMapper {

    public static RecipeBook mapToRecipeBook(String title, String subtitle, User user, boolean publicityStatus) {
        return RecipeBook.builder()
                .title(title)
                .subtitle(subtitle)
                .user(user)
                .publicityStatus(publicityStatus)
                .build();
    }

    public static RecipeBookResponse.RecipeBookInfoResponse mapToRecipeBookInfo(RecipeBook recipeBook) {
        return RecipeBookResponse.RecipeBookInfoResponse.builder()
                .title(recipeBook.getTitle())
                .subtitle(recipeBook.getSubtitle())
                .build();
    }
}
