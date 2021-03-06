package com.example.demo.security;

import com.example.demo.domain.lombok.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException(email);
        }
        User userDetails = user.get();
        if(userDetails != null) {
            System.out.println("username : " +userDetails.getUsername() + " password : " + userDetails.getPassword() + " role: " +userDetails.getAuthorities());
            System.out.println("username : " +userDetails.getUsername() + " password : " + userDetails.getPassword());
        }
        return userDetails;

    }
}
