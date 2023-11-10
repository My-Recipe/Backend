package com.friedNote.friedNote_backend.common.exception;

import lombok.Getter;

@Getter
public enum Error {
    //user
    USER_NOT_FOUND("존재하지 않는 사용자입니다.", 1000),

    //recipeBook
    RECIPEBOOK_NOT_FOUND("존재하지 않는 레시피북입니다.", 2000),
    //recipe
    RECIPE_NOT_FOUND("존재하지 않는 레시피입니다.", 3000),
    RECIPE_NAME_DUPLICATION("이미 존재하는 레시피 이름입니다.", 3001),

    //S3
    S3_UPLOAD_FAIL("S3 업로드에 실패하였습니다.", 4000),

    //JWT
    JWT_TOKEN_INVALID("유효하지 않은 토큰입니다.", 5000),
    JWT_TOKEN_EXPIRED("만료된 토큰입니다.", 5001),

    //OAUTH
    OAUTH_NOT_FOUND("존재하지 않는 OAUTH입니다.", 6000);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
