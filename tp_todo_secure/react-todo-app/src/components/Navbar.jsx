import React, { useState } from 'react'
import { Outlet, useNavigate } from 'react-router-dom'
import AdminBar from './AdminBar';


const Navbar = () => {

    const navigate = useNavigate();
    const [userInfo,setUserInfo] = useState({
      user:null,
      token:false,
      role:null
    })




  return (
    <>
    <header>
      <nav>
        <p>test</p>
        <button onClick={() => navigate("/login")}>Login</button>
        <button onClick={() => navigate("/register")}>Register</button>
        {
          userInfo.user != null && <AdminBar context={{userInfo,setUserInfo}} />
        }
      </nav>
    </header>
    <main>
        <Outlet context={{userInfo,setUserInfo}}/>
    </main>
    </>
  )
}

export default Navbar
