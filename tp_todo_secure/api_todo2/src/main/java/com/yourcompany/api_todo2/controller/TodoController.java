package com.yourcompany.api_todo2.controller;


import com.yourcompany.api_todo2.dto.BaseReponseDto;
import com.yourcompany.api_todo2.dto.NewTodoDto;
import com.yourcompany.api_todo2.dto.TodoDto;
import com.yourcompany.api_todo2.model.Todo;
import com.yourcompany.api_todo2.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/user")
    private BaseReponseDto getAllTodos(){
        Map<String, List<TodoDto>> data = todoService.getAll();

        return new BaseReponseDto("All todos",data);
    }

    @GetMapping("/admin/{pseudo}") //http://localhost:8090/api/todo/{pseudo}
    private BaseReponseDto getTodoByPseudo(@PathVariable String pseudo) {

        List<TodoDto> data = todoService.getTodoByPseudo(pseudo);

        return new BaseReponseDto("TodoList's "+pseudo,data);
    }

    @PostMapping("/admin/{pseudo}")
    private BaseReponseDto postTodo(@PathVariable String pseudo,@RequestBody NewTodoDto newTodoDto){

        TodoDto data = todoService.saveTodo(pseudo, newTodoDto);

        return new BaseReponseDto("Todo save ", data);

    }

    @PutMapping("/admin/{pseudo}")
    private ResponseEntity<Void> putTodo(@PathVariable String pseudo, @RequestBody TodoDto todoDto) {

        if (todoService.updateTodo(pseudo, todoDto)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/admin/{pseudo}/{todoId}")
    private ResponseEntity<Void> deleteTodo(@PathVariable String pseudo, @PathVariable Long todoId){

        if (todoService.deleteTodo(pseudo, todoId)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();

    }





}
