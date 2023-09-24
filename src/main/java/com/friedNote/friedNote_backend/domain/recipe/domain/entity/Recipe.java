package com.friedNote.friedNote_backend.domain.recipe.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
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
public class Recipe extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    private String recipeName;
    private boolean publicityStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeBook_id")
    private RecipeBook recipeBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Recipe(String recipeName, boolean publicityStatus, RecipeBook recipeBook, User user) {
        this.recipeName = recipeName;
        this.publicityStatus = publicityStatus;
        this.recipeBook = recipeBook;
        this.user = user;
    }

    public void updateRecipeName(String recipeName) {
        if(recipeName!=null&&!Objects.equals(this.recipeName, recipeName) && StringUtils.hasText(recipeName)) {
            this.recipeName = recipeName;
        } else {
            this.recipeName = this.recipeName;
        }
    }
    public void updatePublicityStatus(boolean publicityStatus) {
        this.publicityStatus = publicityStatus;
    }
}
