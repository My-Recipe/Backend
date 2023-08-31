package com.friedNote.friedNote_backend.domain.user.domain.service;

import com.friedNote.friedNote_backend.common.annotation.DomainService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class UserQueryService {

    private final UserRepository userRepository;

    public User findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user;
    }

}
