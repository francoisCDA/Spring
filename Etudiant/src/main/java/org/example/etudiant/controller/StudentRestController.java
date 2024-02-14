package org.example.etudiant.controller;

import lombok.RequiredArgsConstructor;
import org.example.etudiant.model.Student;
import org.example.etudiant.service.SpringService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("student/api/v1")
@RequiredArgsConstructor
public class StudentRestController {

    private final SpringService<Student> studentService;


    @GetMapping("students")
    public List<Student> students(){
        return studentService.getAll();
    }

    @GetMapping("student/{id}")
    public Student student(@PathVariable UUID id){
        return studentService.getById(id);
    }

    @PostMapping("add/")
    public void registration(){

    }

}
