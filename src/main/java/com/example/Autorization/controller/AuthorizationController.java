package com.example.Autorization.controller;

import com.example.Autorization.model.User;
import com.example.Autorization.repository.Authorities;
import com.example.Autorization.service.AuthorizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    AuthorizationService service;


    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        System.out.println("/authorize: " + user.getName() + "  +  " + user.getPassword());
        return service.getAuthorities(user.getName(), user.getPassword());
    }

    @PostMapping("/registration")
    public String setRegistration(@RequestBody String body) {
        String[] bodyUser = body
                .replace("user=", "")
                .replace("password=", "")
                .split("&");

        @Valid User user = new User(bodyUser[0], bodyUser[1]);
        return service.setRegistration(user.getName(), user.getPassword());
    }
}
