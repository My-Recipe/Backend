package com.myRecipe.myRecipe_backend.domain.recipeBook.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecipeBook {

    @Id @GeneratedValue
    @Column(name = "recipe_book_id")
    private Long id;

    private String title;
    private String subtitle;

    @Builder
    public RecipeBook(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }
}
