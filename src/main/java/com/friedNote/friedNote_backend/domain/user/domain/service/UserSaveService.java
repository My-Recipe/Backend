package com.friedNote.friedNote_backend.domain.user.domain.service;

import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserSaveService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
