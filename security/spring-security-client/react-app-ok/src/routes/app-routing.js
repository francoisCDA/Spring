import { createBrowserRouter } from "react-router-dom";

import Login from "../components/Login";
import ProtectedRoute from "../components/ProtectedRoute";
import ProductList from "../components/ProductList";
import Header from "../shared/Header";
import FormProduct from "../components/FormProduct";
import Register from "../components/Register";


const router = createBrowserRouter([
    {
        path:"/",
        element: <Header />,
        children: [
            {
                path:"/login",
                element: <Login />
            },
            {
                path:'/register',
                element: <Register />
            },
            {
                path:'/products',
                element: <ProtectedRoute><ProductList/></ProtectedRoute>
            },
            {
                path:'/create-product',
                element: <ProtectedRoute><FormProduct/></ProtectedRoute>
            },
            {
                path:'/update',
                element: <ProtectedRoute><FormProduct/></ProtectedRoute>
            }
        ]
    }

])

export default router;