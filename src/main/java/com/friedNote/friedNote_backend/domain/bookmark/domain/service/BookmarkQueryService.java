package com.friedNote.friedNote_backend.domain.bookmark.domain.service;

import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import com.friedNote.friedNote_backend.domain.bookmark.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkQueryService {

    private final BookmarkRepository bookmarkRepository;

    public List<Bookmark> findByUserId(Long userId) {
        return bookmarkRepository.findByUserId(userId);
    }

    public boolean existsByUserIdAndRecipeId(Long userId, Long recipeId) {
        return bookmarkRepository.existsByUserIdAndRecipeId(userId, recipeId);
    }
}
