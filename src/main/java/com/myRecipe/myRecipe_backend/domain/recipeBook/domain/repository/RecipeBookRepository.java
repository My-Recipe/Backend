package com.myRecipe.myRecipe_backend.domain.recipeBook.domain.repository;

import com.myRecipe.myRecipe_backend.domain.recipeBook.domain.entity.RecipeBook;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeBookRepository extends JpaRepository<RecipeBook, Long> {
}
