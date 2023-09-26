package com.friedNote.friedNote_backend.domain.user.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.common.util.UserUtils;
import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class UserUpdateUseCase {

    private final UserUtils userUtils;

    @Transactional
    public void userUpdate(UserRequest.UserUpdateRequest userUpdateRequest) {

        String name = userUpdateRequest.getName();
        String email = userUpdateRequest.getEmail();
        String profileUrl = userUpdateRequest.getProfileUrl();

        User user = userUtils.getUser();
        user.updateUserInfo(name, email, profileUrl);
    }
}
