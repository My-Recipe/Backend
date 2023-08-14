package com.myRecipe.myRecipe_backend.domain.user.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String email;
    private String profileUrl;

    @Builder
    public User(String name, String email, String profileUrl) {
        this.name = name;
        this.email = email;
        this.profileUrl = profileUrl;
    }
}
