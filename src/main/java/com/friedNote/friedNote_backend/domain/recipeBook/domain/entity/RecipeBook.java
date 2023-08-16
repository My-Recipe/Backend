package com.friedNote.friedNote_backend.domain.recipeBook.domain.entity;

import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecipeBook {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_book_id")
    private Long id;

    private String title;
    private String subtitle;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "recipeBook", cascade =CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> recipeList = new ArrayList<>();

    @Builder
    public RecipeBook(String title, String subtitle, User user) {
        this.title = title;
        this.subtitle = subtitle;
        this.user = user;
    }
}
