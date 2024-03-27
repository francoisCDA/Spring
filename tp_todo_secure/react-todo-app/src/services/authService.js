import api from "./api";

const register = (pseudo, passwd, role) => {
    const user = {
        pseud:pseudo,
        pwd:passwd,
        role:role
    }
    console.log(user);
    return api.post('/auth/register',user).then((response) => {
        return response.data;
    });
}


const login = async (username,passwd) => {
    const loginDto = {
        pseudo:username,
        pwd:passwd
    }

    try {
        const response = await api.post("/auth/login",loginDto);
        //  console.log(response);
        //  console.log(response.data);
     
        return response.data;
     
    } catch (err) {
        console.log(err);
        throw err;
    }

}



export default {register, login};