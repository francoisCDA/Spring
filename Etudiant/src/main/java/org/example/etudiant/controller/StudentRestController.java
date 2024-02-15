package org.example.etudiant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.etudiant.model.Student;
import org.example.etudiant.service.SpringService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
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

    @PostMapping
    public Student registration(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody Student student, BindingResult results){
        if (results.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            results.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(" ///// "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        studentService.save(student);
        return new ResponseEntity<>("Etudiant créé avec l'Id " + student.getId(),HttpStatus.CREATED  );
    }

    @PutMapping()
    public Student putpatch(@RequestBody Student student) {
        studentService.update(student);
        return student;
    }

    @PutMapping("/put")
    public ResponseEntity<String> put(@Valid @RequestBody Student student, BindingResult results){
        if (results.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            results.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(" ///// "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        studentService.update(student);
        return new ResponseEntity<>("Etudiant créé avec l'Id " + student.getId(),HttpStatus.ACCEPTED  );
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable UUID id) {
        return studentService.delete(id);
    }



}
