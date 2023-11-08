package com.friedNote.friedNote_backend.domain.recipeBook.domain.repository;

import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeBookRepository extends JpaRepository<RecipeBook, Long> {
    Optional<RecipeBook> findByUserId(Long userId);
}
