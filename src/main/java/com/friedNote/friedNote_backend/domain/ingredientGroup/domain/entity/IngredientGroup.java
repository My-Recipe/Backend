package com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity;

import com.friedNote.friedNote_backend.common.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IngredientGroup extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredientGroup_id")
    private Long id;

    private String ingredientName;
    private Long ingredientAmount;
    private String ingredientUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Builder
    public IngredientGroup(String ingredientName, Long ingredientAmount, String ingredientUnit, Recipe recipe) {
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;
        this.ingredientUnit = ingredientUnit;
        this.recipe = recipe;
    }
}
