package com.friedNote.friedNote_backend.domain.user.presentation;

import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.application.service.UserCreateService;
import com.friedNote.friedNote_backend.domain.user.application.service.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserCreateService userCreateService;
    private final UserUpdateService userUpdateService;

    @PostMapping("/user")
    public void createUser(@RequestBody UserRequest.UserCreateRequest userCreateRequest) {
        userCreateService.createUser(userCreateRequest);
    }

    @PostMapping("/user/update")
    public void updateUser(@RequestBody UserRequest.UserUpdateRequest userUpdateRequest) {
        userUpdateService.userUpdate(userUpdateRequest);
    }
}
