import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import { RouterProvider } from 'react-router-dom'

import RouterJsx from './routes/RouterJsx.jsx'


// import { createBrowserRouter } from "react-router-dom"
// import Navbar from './components/Navbar.jsx'
// import Home from './pages/Home.jsx'
// import Login2 from './pages/Login2.jsx'
// import Register2 from "./pages/Register2.jsx"

// const router = createBrowserRouter (
//     [
//         {
//             path:"/",
//             element:<Navbar/>,
//             children: [
//                 {
//                     path:"/",
//                     element:<Home />,
//                     index:true
//                 },
//                 {
//                     path:"/login",
//                     element:<Login2 />
//                 },
//                 {
//                     path:"/register",
//                     element:<Register2 />
//                 }
//             ]
//         }
//     ]
// );



ReactDOM.createRoot(document.getElementById('root')).render(
  <>
    <RouterProvider router={RouterJsx} />

  </>
  
  
)
