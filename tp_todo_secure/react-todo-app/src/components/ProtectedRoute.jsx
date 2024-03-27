import React from 'react'
import { Navigate, Outlet, useOutletContext } from 'react-router-dom'

const ProtectedRoute = ({role}) => {

    const {userInfo} = useOutletContext()

    if (userInfo.role == role) {
        //console.log("controle OK");
        //console.log(userInfo);
        return <Outlet context={userInfo}/>
    }

    
    return (
       <Navigate to={"/login"} replace />
    )
}

export default ProtectedRoute



