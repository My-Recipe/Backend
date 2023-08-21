package com.friedNote.friedNote_backend.domain.bookmark.domain.repository;

import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    void deleteByUserIdAndRecipeId(Long userId, Long recipeId);

    boolean existsByUserIdAndRecipeId(Long userId, Long recipeId);

    List<Bookmark> findByUserId(Long userId);
}