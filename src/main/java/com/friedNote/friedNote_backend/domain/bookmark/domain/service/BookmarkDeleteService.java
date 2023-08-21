package com.friedNote.friedNote_backend.domain.bookmark.domain.service;

import com.friedNote.friedNote_backend.domain.bookmark.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkDeleteService {

    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public void deleteBookmark(Long userId, Long recipeId){
        bookmarkRepository.deleteByUserIdAndRecipeId(userId, recipeId);
    }
}
