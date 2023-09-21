package com.friedNote.friedNote_backend.common.util;

import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtils {

    private final UserQueryService userQueryService;

    public User getUser(){
        final String userEmail = SecurityUtils.getUserEmail();
        return userQueryService.findByEmail(userEmail);
    }
}