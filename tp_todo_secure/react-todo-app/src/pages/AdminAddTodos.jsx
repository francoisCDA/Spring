import React from 'react'
import todoService from '../services/todoService';
import { useOutletContext, useNavigate } from 'react-router-dom';
import { useState } from 'react';

const AdminAddTodos = () => {
  const {user,token} = useOutletContext();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    title: '',
    description: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    todoService.postAdminTodo(user,token,formData.title,formData.description).then(() => {
      navigate(`/${user}/todos`)
    })

    setFormData({
      title: '',
      description: ''
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="title">Titre :</label>
        <input
          type="text"
          id="title"
          name="title"
          value={formData.title}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <label htmlFor="description">Description :</label>
        <textarea
          id="description"
          name="description"
          value={formData.description}
          onChange={handleChange}
          required
        />
      </div>
      <button type="submit">Enregistrer</button>
    </form>
  );
}

export default AdminAddTodos
