package org.example.etudiant.controller;

import lombok.RequiredArgsConstructor;
import org.example.etudiant.model.Student;
import org.example.etudiant.service.SpringService;
import org.example.etudiant.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final SpringService<Student> studentService;

    @GetMapping("/")
    public String accueil(Model model) {
        model.addAttribute("student",new Student());
        return "index";
    }

    @GetMapping("/students")
    public String students(Model model){
        List<Student> students = studentService.getAll();

        model.addAttribute("students",students);

        return "student/students";
    }

    @GetMapping("/student/{idStudent}")
    public String student(@PathVariable("idStudent")UUID id, Model model){
        Student student = studentService.getById(id);
        model.addAttribute("student",student);
        return "student/student";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("student",new Student());
        return "student/registration";
    }

    @PostMapping("/registration")
    public String enregistration(@ModelAttribute("student") Student student) {
        System.out.println(student);
        if (student.getId() == null) {
            if (studentService.save(student)){
                return "redirect:/students";
            }
        } else {
          studentService.update(student);
            return "redirect:/students";
        }

        return "error/error";
    }

    @GetMapping("/search") // peut être fusionnée avec /students en rendant le RequestParam optionnel
    public String search(@RequestParam(value="lastName") String search, Model model){

        List<Student> resultSearch = studentService.searchByName(search);

        if (!resultSearch.isEmpty() && resultSearch != null) {
            model.addAttribute("students",resultSearch);
            return "student/students";
        }

        return "student/search";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable UUID id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable UUID id,Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student",student);
        return "student/registration";
    }


    @GetMapping("/error")
    public String error() {
        return "error/error";
    }

}
