package com.myRecipe.myRecipe_backend.domain.user.application.mapper;

import com.myRecipe.myRecipe_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.myRecipe.myRecipe_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static User mapToUser(String name, String email, String profileUrl, RecipeBook recipeBook) {
        return User.builder()
                .name(name)
                .email(email)
                .profileUrl(profileUrl)
                .recipeBook(recipeBook)
                .build();
    }
}
