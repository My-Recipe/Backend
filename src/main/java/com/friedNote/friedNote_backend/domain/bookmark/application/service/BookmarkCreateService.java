package com.friedNote.friedNote_backend.domain.bookmark.application.service;

import com.friedNote.friedNote_backend.domain.bookmark.application.dto.request.BookmarkRequest;
import com.friedNote.friedNote_backend.domain.bookmark.application.mapper.BookmarkMapper;
import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import com.friedNote.friedNote_backend.domain.bookmark.domain.service.BookmarkSaveService;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkCreateService {

    private final BookmarkSaveService bookmarkSaveService;
    private final UserQueryService userQueryService;
    private final RecipeQueryService recipeQueryService;

    public void createBookmark(BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        Long userId = bookmarkCreateRequest.getUserId();
        User user = userQueryService.findById(userId);

        Long recipeId = bookmarkCreateRequest.getRecipeId();
        Recipe recipe = recipeQueryService.findById(recipeId);

        Bookmark bookmark = BookmarkMapper.mapToBookmark(user, recipe);
        bookmarkSaveService.saveBookmark(bookmark);
    }
}
