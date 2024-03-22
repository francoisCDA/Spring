package com.yourcompany.api_todo2.service;


import com.yourcompany.api_todo2.dto.NewTodoDto;
import com.yourcompany.api_todo2.dto.TodoDto;
import com.yourcompany.api_todo2.model.Todo;
import com.yourcompany.api_todo2.model.User;
import com.yourcompany.api_todo2.repository.TodoRepository;
import com.yourcompany.api_todo2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public TodoDto saveTodo(String pseudo, NewTodoDto newTodoDto) {

        User user = userRepository.findByPseudo(pseudo).orElseThrow(()-> new UsernameNotFoundException("invalid pseudo"));

        Todo todo = Todo.builder()
                .title(newTodoDto.getTitle())
                .description(newTodoDto.getDescription())
                .user(user)
                .isCompleted(false)
                .build();
        todoRepository.save(todo);

        return todo.toTodoDto();


    }

    public Map<String, List<TodoDto>> getAll(){

        Map<String,List<TodoDto>> retour = new HashMap<>();

        List<User> users = userRepository.findAll();

        users.forEach(user -> {
            if (user.getRolename().equals("ROLE_ADMIN")) {
                List<TodoDto> userTodo = todoRepository.findTodosByUserIs(user).stream().map(Todo::toTodoDto).toList();
                retour.put(user.getPseudo(), userTodo);
            }
        });

        return retour;
    }

    public List<TodoDto> getTodoByPseudo(String pseudo) {
        User user = userRepository.findByPseudo(pseudo).orElseThrow(()-> new UsernameNotFoundException("invalid pseudo"));


        return todoRepository.findTodosByUserIs(user).stream().map(Todo::toTodoDto).toList();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public boolean updateTodo(String pseudo, TodoDto todoDto) {

        Todo todoToUpdate = todoRepository.findById(todoDto.getId()).orElseThrow(()-> new EntityNotFoundException("invalid todo"));

        if (todoToUpdate.getUser().getPseudo().equals(pseudo)) {

            todoToUpdate.setTitle(todoDto.getTitle());
            todoToUpdate.setDescription(todoDto.getDescription());
            todoToUpdate.setCompleted(todoDto.getIsCompleted());

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
