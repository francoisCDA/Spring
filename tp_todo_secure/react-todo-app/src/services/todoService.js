import api from "./api"


const getAllTodos = async (token) => {
    const response = await api.get('/todo/user',{ headers: mkHeader(token) })
    return response.data;
}


const getAdminTodo = async (adminName,token) => {

    try {

      //  console.log(token)
        
        const response = await api.get(`/todo/admin/${adminName}`,{ headers: mkHeader(token) });
      //   console.log(response);

        return response.data;

    } catch (error) {
        console.log("get Amin Todo Fail");
        throw error;
    }

}

const postAdminTodo = async (adminName, token, title, description ) => {

    const newTodo = {
        title:title,
        description:description
    }

  //  console.log(adminName,'\n',token,'\n',newTodo)

    const response = await api.post(`/todo/admin/${adminName}`, newTodo ,{ headers: mkHeader(token)})
    
    return response.data;

}


function mkHeader(token) {
    const ret = { Authorization: 'Bearer ' + token };
  // console.log(ret)
    return ret

}

export default {getAdminTodo, getAllTodos, postAdminTodo}