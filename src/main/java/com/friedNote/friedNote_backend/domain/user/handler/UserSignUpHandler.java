package com.friedNote.friedNote_backend.domain.user.handler;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.application.mapper.UserMapper;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserQueryService;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class UserSignUpHandler {

    private final UserSaveService userSaveService;
    private final UserQueryService userQueryService;

    @Transactional
    @EventListener
    public void signUp(UserRequest.UserSignUpRequest request){
        final User user = UserMapper.mapToUser(request);

        if(!userQueryService.existsByEmail(user.getEmail())){
            userSaveService.saveUser(user);
        }
    }
}