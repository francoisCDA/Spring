package com.yourcompany.api_todo2.controller;


import com.yourcompany.api_todo2.dto.BaseReponseDto;
import com.yourcompany.api_todo2.dto.LoginDto;
import com.yourcompany.api_todo2.dto.UserDto;
import com.yourcompany.api_todo2.service.UserService;
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

    @PostMapping("/register") //http://localhost:8090/api/auth/register
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

    @PostMapping("/login") //http://localhost:8090/api/auth/login
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
