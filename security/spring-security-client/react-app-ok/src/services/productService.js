import api from './api';
import { authHeader } from '../helpers/auth-header';

const getAllProducts = () => {
  return api.get('/products', { headers: authHeader() });
};



const saveProduct = (name, price) => {

  const product = {
    name: name,
    price: price
  }

 api.post("products/admin/post", product, { headers: authHeader() });

}


const rmProduct = (idToRemove) => {
  
  return api.delete(`/products/${idToRemove}`,{headers: authHeader()});
  
}

const updProduct = ( product ) => {
  return api.put('/products', product ,{ headers: authHeader() });
}


export const productService = { getAllProducts, saveProduct, rmProduct, updProduct};