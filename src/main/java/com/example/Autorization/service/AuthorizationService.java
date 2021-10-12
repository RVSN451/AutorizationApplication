package com.example.Autorization.service;

import com.example.Autorization.exсeption.InvalidCredentials;
import com.example.Autorization.exсeption.UnauthorizedUser;
import com.example.Autorization.repository.Authorities;
import com.example.Autorization.repository.AuthorizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorizationService {
    AuthorizationRepository userRepository;

    public AuthorizationService(AuthorizationRepository repository) {
        this.userRepository = repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


    public String setRegistration(String name, String password) {
        return userRepository.setRegistration(name, password);
    }
}
