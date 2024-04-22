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
        {
         userInfo.user != null ? 
            <AdminBar context={{userInfo,setUserInfo}} />
         :
            <>
              <span>Welcome </span>
              <button onClick={() => navigate("/login")}>Login</button>
              <button onClick={() => navigate("/register")}>Register</button>
            </>
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
