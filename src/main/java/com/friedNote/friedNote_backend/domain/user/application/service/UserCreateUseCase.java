package com.friedNote.friedNote_backend.domain.user.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class UserCreateUseCase {

    private final UserSaveService userSaveService;

    public void createUser(UserRequest.UserCreateRequest userCreateRequest) {
        String name = userCreateRequest.getName();
        String email = userCreateRequest.getEmail();
        String profileUrl = userCreateRequest.getProfileUrl();

        //User user = UserMapper.mapToUser(name, email, profileUrl);
        //userSaveService.saveUser(user);
    }
}
