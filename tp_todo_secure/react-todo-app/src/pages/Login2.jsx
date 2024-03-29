import React, { useState } from 'react';
import authService from '../services/authService';
import { useOutletContext } from 'react-router-dom';

const Login2 = () => {
  const context = useOutletContext();
  const [formData, setFormData] = useState({
    username: '',
    password: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    authService.login(formData.username,formData.password).then( (resp)=> {
      if (resp.message == "Success") {
 
        context.setUserInfo({
          user:resp.data.pseudo,
          token:resp.data.token,
          role:resp.data.role
        })

      }
    });    
    
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            name="username"
            value={formData.username}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login2;
