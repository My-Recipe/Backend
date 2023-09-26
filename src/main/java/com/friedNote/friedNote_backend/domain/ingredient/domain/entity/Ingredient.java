package com.friedNote.friedNote_backend.domain.ingredient.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ingredient extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;
    private String ingredientName;
    private Long ingredientAmount;
    private String ingredientUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredientGroup_id")
    private IngredientGroup ingredientGroup;

    @Builder
    public Ingredient(String ingredientName, Long ingredientAmount, String ingredientUnit, IngredientGroup ingredientGroup) {
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;
        this.ingredientUnit = ingredientUnit;
        this.ingredientGroup = ingredientGroup;
    }

    public void updateIngredientName(String ingredientName) {
        if(!Objects.equals(this.ingredientName, ingredientName) && StringUtils.hasText(ingredientName)){
            this.ingredientName = ingredientName;
        }
    }
    public void updateIngredientAmount(Long ingredientAmount) {
        if(!Objects.equals(this.ingredientAmount, ingredientAmount) && ingredientAmount != null){
            this.ingredientAmount = ingredientAmount;
        }
    }
    public void updateIngredientUnit(String ingredientUnit) {
        if(!Objects.equals(this.ingredientUnit, ingredientUnit) && StringUtils.hasText(ingredientUnit)){
            this.ingredientUnit = ingredientUnit;
        }
    }
    public void updateIngredientInfo(String ingredientName, Long ingredientAmount, String ingredientUnit) {
        updateIngredientName(ingredientName);
        updateIngredientAmount(ingredientAmount);
        updateIngredientUnit(ingredientUnit);
    }
}
