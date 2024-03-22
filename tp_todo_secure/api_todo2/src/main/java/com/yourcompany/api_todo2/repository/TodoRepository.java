package com.yourcompany.api_todo2.repository;


import com.yourcompany.api_todo2.model.Todo;
import com.yourcompany.api_todo2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {


    public List<Todo> findTodosByUserIs(User user);


}
