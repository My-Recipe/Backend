package com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity;


import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CookingProcessImage {

    private String imageUrl;
    private boolean representativeImageStatus;

    @Builder
    public CookingProcessImage(String imageUrl, boolean representativeImageStatus) {
        this.imageUrl = imageUrl;
        this.representativeImageStatus = representativeImageStatus;
    }
}
