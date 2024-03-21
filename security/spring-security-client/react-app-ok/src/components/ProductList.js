import React, { useEffect, useState } from 'react';
import { productService } from '../services/productService';
import { useNavigate } from 'react-router-dom';

function ProductList() {
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);
  const [error, setError] = useState('');
  const [reload, setReload] = useState(true);

  useEffect(() => {
    productService.getAllProducts()
      .then(response => {
        console.log(response)
        setProducts(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });
  }, [reload]);


  const rmProduct = (id) => {
   
    productService.rmProduct(id).then(()=>setReload(!reload));
    
  }

  const editProduct = (productToUpdate) => {
    console.log(productToUpdate);
    navigate("/update",{ state : productToUpdate});
  }


  return (
    <div className="container mt-5">
      <h2>Product List</h2>
      {error && <div className="alert alert-danger" role="alert">
        {error}
      </div>}
      <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col"><i class="bi bi-pencil-square"></i></th>
            <th scope="col"><i class="bi bi-trash"></i></th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr key={product.id}>
              <th scope="row">{index + 1}</th>
              <td>{product.name}</td>
              <td>{product.price}</td>
              <td><button className='btn btn-info' onClick={()=>{editProduct(product)}} ><i class="bi bi-arrow-right-short"></i></button></td>
              <td><button className='btn btn-danger' onClick={()=>{rmProduct(product.id)}} ><i class="bi bi-x"></i></button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ProductList;
