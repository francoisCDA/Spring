package org.example.etudiant.service;

import org.example.etudiant.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService implements SpringService<Student> {

    private final Map<UUID, Student> etudiants;


    public StudentService() {
        this.etudiants = new HashMap<>();

        Student studentA = Student.builder().id(UUID.randomUUID()).firstName("Jean").firstName("Robert").age(21).mail("jean.robert@gmail.com").build();
        Student studentB = Student.builder().id(UUID.randomUUID()).firstName("Jeanne").firstName("Milgram").age(21).mail("jeannz.milgram@gmail.com").build();
        Student studentC = Student.builder().id(UUID.randomUUID()).firstName("Jojo").firstName("Robert").age(21).mail("jojo.gates@gmail.com").build();
        Student studentD = Student.builder().id(UUID.randomUUID()).firstName("Jonhy").firstName("Redford").age(21).mail("jo.red@gmail.com").build();
        Student studentE = Student.builder().id(UUID.randomUUID()).firstName("Roger").firstName("Joplins").age(21).mail("ro.jo@gmail.com").build();
        Student studentF = Student.builder().id(UUID.randomUUID()).firstName("Jeannette").firstName("Leclercq").age(21).mail("jleclercq@gmail.com").build();
        Student studentG = Student.builder().id(UUID.randomUUID()).firstName("Jean-Kevin").firstName("Bean").age(21).mail("titi59@gmail.com").build();

        etudiants.put(studentA.getId(),studentA);
        etudiants.put(studentB.getId(),studentB);
        etudiants.put(studentC.getId(),studentC);
        etudiants.put(studentD.getId(),studentD);
        etudiants.put(studentE.getId(),studentF);
        etudiants.put(studentF.getId(),studentF);
        etudiants.put(studentG.getId(),studentG);

    }


    public void save(Student student) {
        etudiants.put(student.getId(),student);
    }

    public List<Student> getAll() {
        return etudiants.values().stream().toList();
    }

    public List<Student> searchByName(String name) {
        return etudiants.values().stream().filter( student -> student.getLastName().equals(name)).toList();
    }

    public Student getById(UUID id) {
        return etudiants.get(id);
    }


}
