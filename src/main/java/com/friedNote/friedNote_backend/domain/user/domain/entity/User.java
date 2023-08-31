package com.friedNote.friedNote_backend.domain.user.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
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
public class User extends BaseTimeEntity {

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

    public void updateUserName(String name) {
        if(!Objects.equals(this.name, name) && StringUtils.hasText(name)) {
            this.name = name;
        }
    }
    public void updateUserEmail(String email) {
        if(!Objects.equals(this.email, email) && StringUtils.hasText(email)) {
            this.email = email;
        }
    }
    public void updateUserProfileUrl(String profileUrl) {
        if(!Objects.equals(this.profileUrl, profileUrl) && StringUtils.hasText(profileUrl)) {
            this.profileUrl = profileUrl;
        }
    }
}
