package org.example.exotodomvn.controller;

import org.example.exotodomvn.service.TodosList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    private final TodosList todosList;

    @Autowired
    public TodoController(TodosList todosList) {
        this.todosList = todosList;
    }

    @RequestMapping("todo")
    public String getTodo(Model model) {

        model.addAttribute("oneTodo",todosList.getTodolist().getFirst());

        return "todo";

    }

    @RequestMapping("todos")
    public String getTodos(Model model) {
        model.addAttribute("allTodos",todosList.getTodolist());

        return "todos";
    }



}
