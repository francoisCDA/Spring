package org.example.etudiant.service;

import java.util.List;
import java.util.UUID;

public interface SpringService<T> {

    void save(T obj);

    List<T> getAll();

    T getById(UUID id);

}
