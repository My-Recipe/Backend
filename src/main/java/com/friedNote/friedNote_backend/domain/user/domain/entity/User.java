package com.friedNote.friedNote_backend.domain.user.domain.entity;

import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String email;
    private String profileUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeBook_id")
    private RecipeBook recipeBook;


    @Builder
    public User(String name, String email, String profileUrl, RecipeBook recipeBook) {
        this.name = name;
        this.email = email;
        this.profileUrl = profileUrl;
        this.recipeBook = recipeBook;
    }
}
