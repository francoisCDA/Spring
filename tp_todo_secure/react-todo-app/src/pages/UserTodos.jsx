import React, { useEffect } from 'react'
import todoService from '../services/todoService'
import { useOutletContext } from 'react-router-dom'

const UserTodos = () => {

  const {token} = useOutletContext();

  const gettodo = async () => {
    try {
      console.log(token);
      const todos = await todoService.getAllTodos(token);
      
      console.log(todos);
    } catch (error) {
      console.log(JSON.stringify(error))
      console.error(error);
    }
  }


  return (
    <>
      <div>UserTodos</div>
      <button onClick={gettodo}>refresh</button>
    </>
  )
}

export default UserTodos