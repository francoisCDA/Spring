package org.example.exotodomvn.controller;

import org.example.exotodomvn.entity.Todo;
import org.example.exotodomvn.service.TodosList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoRestController {

    private final TodosList todosList;

    @Autowired
    public TodoRestController(TodosList todosList) {
        this.todosList = todosList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/todo")
    public Todo getTodo(){
        return todosList.getTodolist().getFirst();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/todos")
    public List<Todo> getTodos(){


        return todosList.getTodolist();

    }


}

