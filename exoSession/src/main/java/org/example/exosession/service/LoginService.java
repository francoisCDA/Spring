package org.example.exosession.service;


import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final String username;

    private final String password;


    public LoginService() {
        this.username = "root";
        this.password = "totoadmin";
    }

    public boolean isUser(String login, String mdp) {
        return username.equals(login) && password.equals(mdp);
    }

}
