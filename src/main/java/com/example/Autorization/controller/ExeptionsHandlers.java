package com.example.Autorization.controller;

import com.example.Autorization.exсeption.InvalidCredentials;
import com.example.Autorization.exсeption.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExeptionsHandlers {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsEx(InvalidCredentials e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserEx(UnauthorizedUser e) {
        System.out.println(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getLocalizedMessage());
    }


}
