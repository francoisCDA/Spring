import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { productService }  from "../services/productService";

const FormProduct = (data) => {

    const navigate = useNavigate();
    const location = useLocation();
   
    const [newProduct,setNewProduct] = useState({id :0,name:'',price:0.0})

    const addProduct = async (e) => {
        e.preventDefault();

        try {
          if (newProduct.id == 0) {
            productService.saveProduct(newProduct.name,newProduct.price);
          } else {
            productService.updProduct(newProduct);
          }
           
        } catch (error)  {
            console.log(error)
        }

        navigate('/products');
    }

    useEffect( () => {
      
      const productToUpdate = location.state
       if (productToUpdate != null ){
        setNewProduct(productToUpdate)
       }
       console.log(newProduct)
    },[])

    return (
     <>
        <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card mt-5">
            <div className="card-body">
              <h2 className="card-title text-center">{ newProduct.id == 0 ? 'Ajouter' : 'Modifier' } un produit</h2>
            
              <form onSubmit={addProduct} >
                <div className="mb-3">
                  <label htmlFor="nomProduct" className="form-label">Nom du produit</label>
                  <input 
                    type="text" 
                    className="form-control" 
                    id="nomProduct"
                    value={newProduct.name} 
                    onChange={(e) => setNewProduct(prev => ({...prev,name:e.target.value}))} 
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Prix</label>
                  <input 
                    type="number" 
                    className="form-control" 
                    id="password"
                    step="0.01"
                    value={newProduct.price} 
                    onChange={(e) => setNewProduct(prev => ({...prev,price:e.target.value}))} 
                  />
                </div>
                <div className="d-grid gap-2">
                  <button type="submit" className="btn btn-primary">{ newProduct.id == 0 ? 'Ajouter' : 'Modifier' } produit</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>


    </>   
    )
}

export default FormProduct;