package com.yourcompany.api_todo2.service;


import com.yourcompany.api_todo2.dto.NewTodoDto;
import com.yourcompany.api_todo2.dto.UpdateTodoDto;
import com.yourcompany.api_todo2.model.Todo;
import com.yourcompany.api_todo2.model.User;
import com.yourcompany.api_todo2.repository.TodoRepository;
import com.yourcompany.api_todo2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo saveTodo(String pseudo, NewTodoDto newTodoDto) {

        User user = userRepository.findByPseudo(pseudo).orElseThrow(()-> new UsernameNotFoundException("invalid pseudo"));

        Todo todo = Todo.builder()
                .title(newTodoDto.getTitle())
                .description(newTodoDto.getDescription())
                .user(user)
                .isCompleted(false)
                .build();
        return todoRepository.save(todo);


    }

    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    public List<Todo> getTodoByPseudo(String pseudo) {
        User user = userRepository.findByPseudo(pseudo).orElseThrow(()-> new UsernameNotFoundException("invalid pseudo"));
        return todoRepository.findTodosByUserIs(user);
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public boolean updateTodo(String pseudo, UpdateTodoDto updateTodoDto) {

        Todo todoToUpdate = todoRepository.findById(updateTodoDto.getId()).orElseThrow(()-> new EntityNotFoundException("invalid todo"));

        if (todoToUpdate.getUser().getPseudo().equals(pseudo)) {

            todoToUpdate.setTitle(updateTodoDto.getTitle());
            todoToUpdate.setDescription(updateTodoDto.getDescription());
            todoToUpdate.setCompleted(updateTodoDto.getIsCompleted());

            todoRepository.save(todoToUpdate);

            return true;

        }

        return false;
    }

    public boolean deleteTodo(String pseudo, Long id) {

        Todo todoToRemove = todoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("invalid todo"));

        if (todoToRemove.getUser().getPseudo().equals(pseudo)){
            todoRepository.deleteById(id);
            return true;
        }

        return false;


    }

}
