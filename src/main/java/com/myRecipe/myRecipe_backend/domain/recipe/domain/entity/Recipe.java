package com.myRecipe.myRecipe_backend.domain.recipe.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    private String dishName;
    private boolean publicityStatus;

    @Builder
    public Recipe(String dishName, boolean publicityStatus) {
        this.dishName = dishName;
        this.publicityStatus = publicityStatus;
    }
}
