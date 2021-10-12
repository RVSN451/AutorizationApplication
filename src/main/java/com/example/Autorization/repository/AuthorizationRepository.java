package com.example.Autorization.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AuthorizationRepository {
    Map<HashMap<String, String>, List<Authorities>> users = new HashMap<>();

    public AuthorizationRepository() {
        HashMap<String, String> u1 = new HashMap<>();
        u1.put("U1", "111");
        List<Authorities> authoritiesU1 = Arrays.asList(Authorities.values());
        users.put(u1, authoritiesU1);

        HashMap<String, String> u2 = new HashMap<>();
        u2.put("U2", "222");
        List<Authorities> authoritiesU2 = new ArrayList<>();
        authoritiesU2.add(Authorities.READ);
        authoritiesU2.add(Authorities.WRITE);
        users.put(u2, authoritiesU2);
    }


    public List<Authorities> getAuthorities(String user, String password) {

        HashMap<String, String> userKey = new HashMap<>();
        userKey.put(user, password);

        return users.get(userKey);
    }

    public String setRegistration(String name, String password) {
        String response = "";
        HashMap<String, String> newUser = new HashMap<>();
        newUser.put(name, password);
        if (users.containsKey(newUser)){
            response = name + " - this username+password is already taken. Try something else.";
        } else {
            response = name + " - registration completed successfully";
            users.put(newUser, Arrays.asList(Authorities.values()));
        }
        return response;
    }
}
