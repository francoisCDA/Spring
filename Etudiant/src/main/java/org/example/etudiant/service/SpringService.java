package org.example.etudiant.service;

import java.util.List;
import java.util.UUID;

public interface SpringService<T> {

    boolean save(T obj);

    List<T> getAll();

    T getById(UUID id);


    List<T> searchByName(String search);

    boolean delete(UUID id);

    void update(T student);
}
