package com.friedNote.friedNote_backend.domain.recipeBook.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
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

    public void updateRecipeBookTitle(String title) {
        if(!Objects.equals(this.title, title)&& StringUtils.hasText(title)) {
            this.title = title;
        }
    }
    public void updateRecipeBookSubtitle(String subtitle) {
        if(!Objects.equals(this.subtitle, subtitle)&& StringUtils.hasText(subtitle)) {
            this.subtitle = subtitle;
        }
    }
    public void updateRecipeBookPublicityStatus(boolean publicityStatus) {
        this.publicityStatus = publicityStatus;
    }

    public void updateRecipeBookInfo(String title, String subtitle, boolean publicityStatus) {
        updateRecipeBookTitle(title);
        updateRecipeBookSubtitle(subtitle);
        updateRecipeBookPublicityStatus(publicityStatus);
    }
}
