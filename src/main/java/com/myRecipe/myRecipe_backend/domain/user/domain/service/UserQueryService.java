package com.myRecipe.myRecipe_backend.domain.user.domain.service;

import com.myRecipe.myRecipe_backend.domain.user.domain.entity.User;
import com.myRecipe.myRecipe_backend.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    public User findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user;

    }
}
