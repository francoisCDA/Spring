import React, { useEffect } from 'react'
import { useOutletContext } from 'react-router-dom'
import todoService from '../services/todoService'

const AdminTodos = () => {

  const {user,token} = useOutletContext();

  useEffect( () => {
    //console.log(user);
    const adminTodos = todoService.getAdminTodo(user,token);

    console.log(adminTodos);

  },[])


  return (
    <div>
      <h1>Admin todos</h1>
    </div>
  )
}

export default AdminTodos
