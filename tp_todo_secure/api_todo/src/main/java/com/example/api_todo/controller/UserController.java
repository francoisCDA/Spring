package com.example.api_todo.controller;

import com.example.api_todo.dto.BaseReponseDto;
import com.example.api_todo.dto.LoginDto;
import com.example.api_todo.dto.UserDto;
import com.example.api_todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BaseReponseDto registerUser(@RequestBody UserDto userDto) {

        try {
            if (userService.createUser(userDto)) {
                return  new BaseReponseDto("Success");
            }

        } catch (RoleNotFoundException e) {
            return new BaseReponseDto(e.getMessage());
        }
        return new BaseReponseDto("failed");
    }

    @PostMapping("/login")
    public BaseReponseDto login(@RequestBody LoginDto loginDto) {

        if (userService.checkUserPseudoExists(loginDto.getPseudo())) {
            if (userService.verifyUser(loginDto.getPseudo(), loginDto.getPwd())) {
                Map<String, Object> data = new HashMap<>();

                data.put("token", userService.generateToken(loginDto.getPseudo(), loginDto.getPwd()));

                data.put("pseudo", loginDto.getPseudo());

                return new BaseReponseDto("Success", data);

            }

        }

        return new BaseReponseDto("Invalid connexion");
    }



}
