import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom';
import authService from '../services/authService';

const Register2 = () => {

  const navig = useNavigate();
  const [formData, setFormData] = useState({
    username: '',
    role: '',
    password1: '',
    password2: ''
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

   // console.log(formData);

    if (formData.password1 != formData.password2) {
      setFormData({
        password1: '',
        password2: ''
      });
    } else {
      const message = authService.register(formData.username,formData.password1,formData.role);
      console.log(message);
      navig("/");
    }

    
  };

  return (
<div>
      <h2>Register</h2>
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
        <label htmlFor="role">Role:</label>
        <select
          id="role"
          name="role"
          value={formData.role}
          onChange={handleChange}
          required
        >
          <option value="">-- Sélectionner un rôle --</option>
          <option value="ROLE_ADMIN">Admin (gérer une todo)</option>
          <option value="ROLE_USER">User (suivre les todos)</option>
        </select>
        </div>
        <div>
          <label htmlFor="password1">Password:</label>
          <input
            type="password"
            id="password1"
            name="password1"
            value={formData.password1}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="password2">Confirm Password:</label>
          <input
            type="password"
            id="password2"
            name="password2"
            value={formData.password2}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  )
}

export default Register2
