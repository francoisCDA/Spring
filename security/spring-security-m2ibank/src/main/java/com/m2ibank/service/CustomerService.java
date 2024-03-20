package com.m2ibank.service;

import com.m2ibank.model.Customer;
import com.m2ibank.repository.CustomerRepository;
import com.m2ibank.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public String generateToken(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtProvider.generateToken(authentication);
    }

    public boolean checkCustomerNameExists(String email) {
        Customer customer = customerRepository.findByEmail(email).getFirst();
        return  customer != null;
    }

    public boolean verifyUser(String email, String password) {
        Customer customer = customerRepository.findByEmail(email).getFirst();
        return passwordEncoder.matches(password, customer.getPassword());
    }

    public boolean createCustomer(Customer customer){
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customerRepository.save(customer);
        return true;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email).getFirst();

        if (customer != null) {
            return customer;
        }
        throw new UsernameNotFoundException("Client non trouvé : " + email );
    }
}
