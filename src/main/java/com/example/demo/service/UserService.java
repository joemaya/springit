package com.example.demo.service;

import com.example.demo.domain.lombok.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return user;
    }

    public User save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User ... users) {
        for(User user: users) {
            logger.info("Saving user " + user.getEmail());
            userRepository.save(user);
        }
    }

    @Transactional(readlOnly="true")
    public Optional<User> findById(Long id) {
        userRepository.findById(id);
    }
}
