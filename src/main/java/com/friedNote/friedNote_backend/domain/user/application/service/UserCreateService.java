package com.friedNote.friedNote_backend.domain.user.application.service;

import com.friedNote.friedNote_backend.domain.recipeBook.domain.service.RecipeBookQueryService;
import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.application.mapper.UserMapper;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCreateService {
    private final UserSaveService userSaveService;
    private final RecipeBookQueryService recipeBookQueryService;

    public void createUser(UserRequest.UserCreateRequest userCreateRequest) {
        String name = userCreateRequest.getName();
        String email = userCreateRequest.getEmail();
        String profileUrl = userCreateRequest.getProfileUrl();

        User user = UserMapper.mapToUser(name, email, profileUrl);
        userSaveService.saveUser(user);
    }
}
