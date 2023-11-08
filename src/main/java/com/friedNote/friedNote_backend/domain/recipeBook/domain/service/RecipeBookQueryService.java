package com.friedNote.friedNote_backend.domain.recipeBook.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.common.exception.Error;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.exception.RecipeBookNotFoundException;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.repository.RecipeBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class RecipeBookQueryService {

    private final RecipeBookRepository recipeBookRepository;

    public RecipeBook findByUserId(Long userId) {
        RecipeBook recipeBook = recipeBookRepository.findByUserId(userId)
                .orElseThrow(()-> new RecipeBookNotFoundException(Error.RECIPEBOOK_NOT_FOUND));
        return recipeBook;
    }
}
