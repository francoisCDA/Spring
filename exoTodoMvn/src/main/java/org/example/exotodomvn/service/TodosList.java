package org.example.exotodomvn.service;

import lombok.Data;
import lombok.Getter;
import org.example.exotodomvn.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
@Data
public class TodosList {

    private List<Todo> todolist;

    public TodosList(){
        todolist = new ArrayList<>();
        todolist.add(new Todo("test1","faire un test",true));
        todolist.add(new Todo("test2","faire un autre test",true));
        todolist.add(new Todo("test3","les tests c'est la vie",true));
        todolist.add(new Todo("Aperture Sciences","We do what we must because we can", true));
        todolist.add(new Todo("GLADOS","Remplacer les neurotoxines par des placébos", true));
    }

    public Todo getToDoByIndex(int idx) {
        return todolist.get(idx);
    }
    public void changeStatusTodoByIdx(int idx) {
        getToDoByIndex(idx).setStatus(!getToDoByIndex(idx).isStatus());
    }

    public void pushTodo(String nom,String description, boolean status) {
        pushTodo(new Todo(nom,description,status));
    }

    public void pushTodo(Todo newTodo){
        todolist.add(newTodo);
    }

    public void deleteByIdx(int idx) {
        todolist.remove(idx);
    }


}
