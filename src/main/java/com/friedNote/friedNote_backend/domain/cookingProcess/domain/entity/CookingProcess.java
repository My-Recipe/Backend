package com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity;

import com.friedNote.friedNote_backend.common.domain.BaseTimeEntity;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
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
public class CookingProcess extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cooking_process_id")
    private Long id;

    private String cookingProcessSequence;
    private String description;
    private CookingProcessImage cookingProcessImage;
    private String tip;
    private Long time; //단위에 대한 고민?

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Builder
    public CookingProcess(String cookingProcessSequence, String description, CookingProcessImage cookingProcessImage,
                          String tip, Long time, Recipe recipe) {
        this.cookingProcessSequence = cookingProcessSequence;
        this.description = description;
        this.cookingProcessImage = cookingProcessImage;
        this.tip = tip;
        this.time = time;
        this.recipe = recipe;
    }

    public void updateDescription(String description) {
        if(description!=null&&!Objects.equals(this.description, description)&& StringUtils.hasText(description)) {
            this.description = description;
        }
    }
    public void updateCookingProcessImage(CookingProcessImage cookingProcessImage) {
        if (cookingProcessImage!=null&&!Objects.equals(this.cookingProcessImage, cookingProcessImage)){
            this.cookingProcessImage = cookingProcessImage;
        }
    }
    public void updateTip(String tip) {
        if(tip!=null&&!Objects.equals(this.tip, tip)&& StringUtils.hasText(tip)) {
            this.tip = tip;
        }
    }
    public void updateTime(Long time) {
        if(time!=null&&!Objects.equals(this.time, time)) {
            this.time = time;
        }
    }
    public void updateCookingProcessSequence(String cookingProcessSequence) {
        if(cookingProcessSequence!=null&&!Objects.equals(this.cookingProcessSequence, cookingProcessSequence)&& StringUtils.hasText(cookingProcessSequence)){
            this.cookingProcessSequence = cookingProcessSequence;
        }
    }
    public void updateCookingProcessInfo(String cookingProcessSequence, String description, CookingProcessImage cookingProcessImage,
                                         String tip, Long time) {
        updateCookingProcessSequence(cookingProcessSequence);
        updateDescription(description);
        updateCookingProcessImage(cookingProcessImage);
        updateTip(tip);
        updateTime(time);
    }
}
