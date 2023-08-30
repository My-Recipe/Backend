package com.friedNote.friedNote_backend.domain.user.application.service;

import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserQueryService userQueryService;

    @Transactional
    public void userUpdate(UserRequest.UserUpdateRequest userUpdateRequest) {
        //유저 정보를 업데이트 하는 로직
        Long userId = userUpdateRequest.getUserId();
        String name = userUpdateRequest.getName();

        User user = userQueryService.findById(userId);
        user.updateUser(name);
    }
}
