package com.myRecipe.myRecipe_backend.domain.user.application.service;

import com.myRecipe.myRecipe_backend.domain.user.application.dto.request.UserRequest;
import com.myRecipe.myRecipe_backend.domain.user.application.mapper.UserMapper;
import com.myRecipe.myRecipe_backend.domain.user.domain.entity.User;
import com.myRecipe.myRecipe_backend.domain.user.domain.service.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {
    private final UserSaveService userSaveService;

    public void createUser(UserRequest.UserCreateRequest userCreateRequest) {
        String name = userCreateRequest.getName();
        String email = userCreateRequest.getEmail();
        String profileUrl = userCreateRequest.getProfileUrl();

        User user = UserMapper.mapToUser(name, email, profileUrl);
        userSaveService.saveUser(user);
    }
}
