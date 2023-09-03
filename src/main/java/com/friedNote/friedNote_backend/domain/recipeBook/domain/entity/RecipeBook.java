package com.friedNote.friedNote_backend.domain.recipeBook.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecipeBook extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_book_id")
    private Long id;

    private String title;
    private String subtitle;
    private boolean publicityStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public RecipeBook(String title, String subtitle, boolean publicityStatus, User user) {
        this.title = title;
        this.subtitle = subtitle;
        this.publicityStatus = publicityStatus;
        this.user = user;
    }
}
