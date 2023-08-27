package com.friedNote.friedNote_backend.domain.bookmark.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.bookmark.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class BookmarkDeleteService {

    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public void deleteBookmark(Long userId, Long recipeId){
        bookmarkRepository.deleteByUserIdAndRecipeId(userId, recipeId);
    }
}
