import { Navigate } from "react-router-dom"


const ProtectedRoute = (props) => {
    
    const testUser = localStorage.getItem('user')

    console.log("From ProtectedRoute : " + testUser)

    if ( testUser ) {
        return (
            <>
                {props.children}
            </>
        )
    } else {
        return <Navigate to={"/login"}></Navigate>
    }

}

export default ProtectedRoute;