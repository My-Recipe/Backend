package com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity;


import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Objects;

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

    public void updateCookingProcessImage(String imageUrl) {
        if(!Objects.equals(this.imageUrl, imageUrl) && StringUtils.hasText(imageUrl)){
            this.imageUrl = imageUrl;
        }
    }
    public void updateRepresentativeImageStatus(boolean representativeImageStatus) {
        this.representativeImageStatus = representativeImageStatus;
    }
}
