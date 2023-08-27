package com.friedNote.friedNote_backend.domain.recipeBook.domain.service;

import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.repository.RecipeBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RecipeBookSaveService {

    private final RecipeBookRepository recipeBookRepository;

    public void saveRecipeBook(RecipeBook recipeBook) {
        recipeBookRepository.save(recipeBook);
    }
}
