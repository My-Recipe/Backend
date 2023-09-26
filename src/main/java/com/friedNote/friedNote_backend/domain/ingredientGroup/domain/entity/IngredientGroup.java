package com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IngredientGroup extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredientGroup_id")
    private Long id;

    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @OneToMany(mappedBy = "ingredientGroup")
    private List<Ingredient> ingredientList = new ArrayList<>();

    @Builder
    public IngredientGroup(String groupName, Recipe recipe) {
        this.groupName = groupName;
        this.recipe = recipe;
    }

    public void updateIngredientGroupName(String groupName) {
        if(!Objects.equals(this.groupName, groupName) && StringUtils.hasText(groupName)){
            this.groupName = groupName;
        }
    }
}
