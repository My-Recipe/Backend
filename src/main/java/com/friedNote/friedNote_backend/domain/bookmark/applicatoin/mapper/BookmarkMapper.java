package com.friedNote.friedNote_backend.domain.bookmark.applicatoin.mapper;

import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookmarkMapper {

    public static Bookmark mapToBookmark(User user, Recipe recipe) {
        return Bookmark.builder()
                .user(user)
                .recipe(recipe)
                .build();
    }
}
