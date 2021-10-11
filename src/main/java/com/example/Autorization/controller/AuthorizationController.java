package com.example.Autorization.controller;

import com.example.Autorization.repository.Authorities;
import com.example.Autorization.repository.AuthorizationRepository;
import com.example.Autorization.service.AuthorizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;


    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
