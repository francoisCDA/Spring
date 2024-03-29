import React from 'react'
import { useNavigate } from 'react-router-dom'

const AdminBar = ({context}) => {

    const navigate = useNavigate();

    const logout = () => {
        context.setUserInfo({
          user:null,
          token:false,
          role:null
        })
        navigate("/login")
      }


  return (
    <div>
        <span>Welcome {context.userInfo.user} </span>
        <button onClick={logout}>Logout</button>
        {context.userInfo.role == "ADMIN" && 
            <>
                <button onClick={() => navigate(`/${context.userInfo.user}/todos`)}>Mes Todos</button>
                <button onClick={() => navigate(`/${context.userInfo.user}/todos/add`)}>New Todo</button>
            </>
        }
        {
            context.userInfo.role == "USER" && 
            <>
                    <button onClick={() => navigate(`/all/todos`)}>Les Todos</button>
            </> 
        }
    </div>
  )
}

export default AdminBar
