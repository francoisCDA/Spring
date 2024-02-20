package org.example.exosession.controller;


import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.example.exosession.exception.IdentificationException;
import org.example.exosession.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class LoginController {

    private HttpSession _httpSession;
    private LoginService loginService;


    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (loginService.isUser(username,password)) {
            _httpSession.setAttribute("root", true);
        }

        return "redirect:/admin";

    }

    @GetMapping("/admin")
    public String admin() throws IdentificationException {
        boolean isAdmin = (boolean) _httpSession.getAttribute("root");
        if (isAdmin) {
            return "site/admin";
        }
        throw new IdentificationException();
    }


    @ExceptionHandler(IdentificationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleFailConnection(IdentificationException ex, Model model) {
        model.addAttribute("error",ex.getMessage());
        return "site/error";
    }





}
