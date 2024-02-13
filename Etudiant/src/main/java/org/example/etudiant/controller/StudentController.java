package org.example.etudiant.controller;

import lombok.RequiredArgsConstructor;
import org.example.etudiant.model.Student;
import org.example.etudiant.service.SpringService;
import org.example.etudiant.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final SpringService<Student> studentService;

    @GetMapping("/")
    public String accueil() {

        return "index";
    }

    @GetMapping("/sudents")
    public String students(Model model){
        List<Student> students = studentService.getAll();

        model.addAttribute("students",students);

        return "student/students";
    }

    @GetMapping("/registration")
    public String registration() {

        return "student/registration";
    }

    @PostMapping("/registration")
    public String enregistration() {
        return "/";
    }

    @GetMapping("/search")
    public String search(){
        return "student/search";
    }

    @PostMapping("/search")
    public String research(){
        return "/";
    }


    @GetMapping("/error")
    public String error() {
        return "error/error";
    }

}
