import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import ProductList from './components/ProductList';
import Header from './shared/Header';
import FormProduct from './components/FormProduct';


function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/products" element={<ProductList />} />
        <Route path="/create-product" element={<FormProduct />} />
        <Route path="/update" element={<FormProduct />} />
        <Route path="/" element={<Login />} />
      </Routes>
    </Router>
  );
}

export default App;

