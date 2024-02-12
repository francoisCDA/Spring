package org.example.exotodomvn.service;

import lombok.Data;
import lombok.Getter;
import org.example.exotodomvn.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class TodosList {

    private List<Todo> todolist;

    private TodosList(){
        todolist = new ArrayList<>();
        todolist.add(new Todo("test1","faire un test",true));
        todolist.add(new Todo("test2","faire un autre test",true));
        todolist.add(new Todo("test3","les tests c'est la vie",true));
        todolist.add(new Todo("Aperture Sciences","We do what we must because we can", true));
    }


}
