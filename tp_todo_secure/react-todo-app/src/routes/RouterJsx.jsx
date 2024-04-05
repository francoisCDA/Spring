import { createBrowserRouter } from "react-router-dom"
import Navbar from "../components/Navbar.jsx"
import Home from '../pages/Home.jsx'
import Login2 from '../pages/Login2.jsx'
import Register2 from "../pages/Register2.jsx"
import ProtectedRoute from "../components/ProtectedRoute.jsx"
import AdminTodos from "../pages/AdminTodos.jsx"
import AdminAddTodos from "../pages/AdminAddTodos.jsx"
import UserTodos from "../pages/UserTodos.jsx"

const RouterJsx = createBrowserRouter (
    [
        {
            path:"/",
            element:<Navbar/>,
            children: [
                {
                    path:"/",
                    element:<Home />,
                    index:true
                },
                {
                    element: <ProtectedRoute role={null} />,
                    children:[                        
                        {
                            path:"/login",
                            element:<Login2 />
                        },
                        {
                            path:"/register",
                            element:<Register2 />
                        }
                    ]
                },
                {
                    element: <ProtectedRoute role="ADMIN" />,
                    children:[
                        {
                            path:"/:user/todos",
                            element: <AdminTodos />
                        },
                        {
                            path:"/:user/todos/add",
                            element: <AdminAddTodos />
                        },

                    ]
                },{
                    element: <ProtectedRoute role="USER" />,
                    children:[
                        {
                            path:"/all/todos",
                            element: <UserTodos />
                        }                    ]
                }
            ]
        }
    ]
);

export default RouterJsx