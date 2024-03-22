package com.example.api_todo.service;

import com.example.api_todo.model.Todo;
import com.example.api_todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

}
