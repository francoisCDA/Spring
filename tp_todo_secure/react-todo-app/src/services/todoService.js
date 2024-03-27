import api from "./api"


const getAllTodos = async (token) => {
    const response = await api.get('/api/todo/user',{ headers: mkHeader(token) })
    return response.data;
}


const getAdminTodo = async (adminName,token) => {

    try {

        console.log(token)
        
        const response = await api.get(`/api/todo/admin/${adminName}`,{ headers: mkHeader(token) });
         console.log(response);

        return response.data;

    } catch (error) {
        console.log("get Amin Todo Fail");
        throw error;
    }

}


function mkHeader(token) {
    const ret = { Authorization: 'Bearer ' + token };
   console.log(ret)
    return ret

}

export default {getAdminTodo, getAllTodos}