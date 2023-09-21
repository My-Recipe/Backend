package com.friedNote.friedNote_backend.domain.user.application.mapper;

import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static User mapToUser(UserRequest.UserSignUpRequest userSignUpRequest) {
        return User.builder()
                .name(userSignUpRequest.getName())
                .email(userSignUpRequest.getEmail())
                .build();
    }
}
