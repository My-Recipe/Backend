package com.friedNote.friedNote_backend.domain.recipe.infrastructure;

import com.friedNote.friedNote_backend.domain.recipe.domain.repository.RecipeRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

}
