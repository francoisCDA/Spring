import React from 'react'
import { Navigate, Outlet, useOutletContext } from 'react-router-dom'

const ProtectedRoute = ({role}) => {

    const {userInfo,setUserInfo} = useOutletContext()

    if (userInfo.role == role) {
        //console.log("controle OK");
        //console.log(userInfo);
        return <Outlet context={{userInfo,setUserInfo}}/>
    }

    
    return (
       <Navigate to={"/login"} replace />
    )
}

export default ProtectedRoute



