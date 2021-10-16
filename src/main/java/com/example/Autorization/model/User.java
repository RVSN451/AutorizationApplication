package com.example.Autorization.model;


import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Validated
public class User {

    @NotBlank
    @Size(min = 5, max = 15)
    private String name;
    @NotBlank
    @Size(min = 5, max = 15)
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
