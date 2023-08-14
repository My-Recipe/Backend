package com.myRecipe.myRecipe_backend.domain.user.domain.service;

import com.myRecipe.myRecipe_backend.domain.user.domain.entity.User;
import com.myRecipe.myRecipe_backend.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSaveService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
