package com.m2ibank.controller;


import com.m2ibank.model.Customer;
import com.m2ibank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/register")
    public String registerCustomer(@RequestBody Customer customer) {
        if (customerService.createCustomer(customer)) {
            return "register";
        } else {
            return "not register";
        }
    }



    @PostMapping("/login")
    public String loginCustomer(@RequestAttribute("email") String email, @RequestAttribute("password") String password) throws Exception {
        if ( customerService.checkCustomerNameExists(email) && customerService.verifyUser(email,password)) {
            return customerService.generateToken(email,password);
        }

        throw new Exception("Inconnue");

    }

}
