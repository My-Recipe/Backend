package com.friedNote.friedNote_backend.domain.user.presentation;

import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.application.service.UserCreateUseCase;
import com.friedNote.friedNote_backend.domain.user.application.service.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserUpdateService userUpdateService;

    private final UserCreateUseCase userCreateUseCase;

    @PostMapping("/user")
    public void createUser(@RequestBody UserRequest.UserCreateRequest userCreateRequest) {
        userCreateUseCase.createUser(userCreateRequest);
    }

    @PostMapping("/user/update")
    public void updateUser(@RequestBody UserRequest.UserUpdateRequest userUpdateRequest) {
        userUpdateService.userUpdate(userUpdateRequest);
    }
}
