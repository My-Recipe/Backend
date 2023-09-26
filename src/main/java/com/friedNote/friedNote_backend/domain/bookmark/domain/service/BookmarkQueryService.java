package com.friedNote.friedNote_backend.domain.bookmark.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import com.friedNote.friedNote_backend.domain.bookmark.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class BookmarkQueryService {

    private final BookmarkRepository bookmarkRepository;

    public List<Bookmark> findByUserId(Long userId) {
        return bookmarkRepository.findByUserId(userId);
    }

    public boolean existsByUserIdAndRecipeId(Long userId, Long recipeId) {
        return bookmarkRepository.existsByUserIdAndRecipeId(userId, recipeId);
    }

    public List<Bookmark> findByCreatedDateBetween(LocalDateTime now, LocalDateTime weekAgo){
        return bookmarkRepository.findByCreatedDateBetween(now, weekAgo);
    }

    public Long countByRecipeId(Long recipeId){
        return bookmarkRepository.countByRecipeId(recipeId);
    }

    public Long countByUserId(Long userId){
        return bookmarkRepository.countByUserId(userId);
    }
}
