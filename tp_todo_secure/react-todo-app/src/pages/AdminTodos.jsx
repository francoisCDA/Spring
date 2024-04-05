import React, { useEffect, useState } from 'react'
import { useOutletContext } from 'react-router-dom'
import todoService from '../services/todoService'

const AdminTodos = () => {

  const {user,token} = useOutletContext();
  const [todoList, setTodoList] = useState([]);

  useEffect( () => {
    
    const axiosTodo = async () =>{
      try {
        const adminTodos = await todoService.getAdminTodo(user,token);
        
      if (Array.isArray(adminTodos.data)) {
        setTodoList(adminTodos.data);
      }
        
      } catch (error) {
        
      }
      
    }

    axiosTodo();


  },[])


  return (
    <div>
      <h1>Admin todos</h1>

      {todoList.length == 0 ? 
        <><h2>`${user}` n'a rien à faire</h2></>
        :
        todoList.map( (todo) => (
          <div key={todo.id}> 
          <span>{todo.title} </span>
          <span>{todo.description} </span>
          <span>{todo.iscompleted ? "terminée" : "en cours"}</span>
          </div>
        ) )
      }


    </div>
  )
}

export default AdminTodos
