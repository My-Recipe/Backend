package com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CookingProcess extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cooking_process_id")
    private Long id;

    private String description;
    private String imageUrl;
    private String tip;
    private Long time; //단위에 대한 고민?

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Builder
    public CookingProcess(String description, String imageUrl, String tip, Long time, Recipe recipe) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.tip = tip;
        this.time = time;
        this.recipe = recipe;
    }
}
