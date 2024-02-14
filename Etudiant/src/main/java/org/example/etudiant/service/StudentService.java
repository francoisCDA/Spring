package org.example.etudiant.service;

import org.example.etudiant.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService implements SpringService<Student> {

    private final Map<UUID, Student> etudiants;


    public StudentService() {
        this.etudiants = new HashMap<>();

        Student studentA = Student.builder().id(UUID.randomUUID()).firstName("Jean").lastName("Robert").birthday(LocalDate.of(2021,12,1)).mail("jean.robert@gmail.com").build();
        Student studentB = Student.builder().id(UUID.randomUUID()).firstName("Jeanne").lastName("Milgram").birthday(LocalDate.of(2021,12,1)).mail("jeannz.milgram@gmail.com").build();
        Student studentC = Student.builder().id(UUID.randomUUID()).firstName("Jojo").lastName("Robert").birthday(LocalDate.of(2021,12,1)).mail("jojo.gates@gmail.com").build();
        Student studentD = Student.builder().id(UUID.randomUUID()).firstName("Jonhy").lastName("Redford").birthday(LocalDate.of(2021,12,1)).mail("jo.red@gmail.com").build();
        Student studentE = Student.builder().id(UUID.randomUUID()).firstName("Roger").lastName("Joplins").birthday(LocalDate.of(2021,12,1)).mail("ro.jo@gmail.com").build();
        Student studentF = Student.builder().id(UUID.randomUUID()).firstName("Jeannette").lastName("Leclercq").birthday(LocalDate.of(2021,12,1)).mail("jleclercq@gmail.com").build();
        Student studentG = Student.builder().id(UUID.randomUUID()).firstName("Jean-Kevin").lastName("Bean").birthday(LocalDate.of(2021,12,1)).mail("titi59@gmail.com").build();

        etudiants.put(studentA.getId(),studentA);
        etudiants.put(studentB.getId(),studentB);
        etudiants.put(studentC.getId(),studentC);
        etudiants.put(studentD.getId(),studentD);
        etudiants.put(studentE.getId(),studentE);
        etudiants.put(studentF.getId(),studentF);
        etudiants.put(studentG.getId(),studentG);

    }

    public boolean save(Student student) {
        student.setId(UUID.randomUUID());
        etudiants.put(student.getId(),student);
        return true;
    }

    public List<Student> getAll() {
        return etudiants.values().stream().toList();
    }

    public List<Student> searchByName(String name) {
        return etudiants.values().stream().filter( student -> student.getLastName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public Student getById(UUID id) {
        return etudiants.get(id);
    }



}
