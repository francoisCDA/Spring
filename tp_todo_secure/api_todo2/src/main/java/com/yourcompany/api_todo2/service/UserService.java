package com.yourcompany.api_todo2.service;


import com.yourcompany.api_todo2.config.jwt.JwtTokenProvider;
import com.yourcompany.api_todo2.dto.UserDto;
import com.yourcompany.api_todo2.model.Role;
import com.yourcompany.api_todo2.model.User;
import com.yourcompany.api_todo2.repository.RoleRepository;
import com.yourcompany.api_todo2.repository.UserRepository;
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

import javax.management.relation.RoleNotFoundException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByPseudo(username).orElseThrow(() -> new UsernameNotFoundException("Pseudo unknow : " + username));
    }

    public boolean createUser(UserDto userdto) throws RoleNotFoundException {

        Role role = roleRepository.findByRole(userdto.getRole()).orElseThrow(() -> new RoleNotFoundException("Invalid Role : " + userdto.getRole()));

        User newUser = User.builder()
                .pseudo(userdto.getPseud())
                .passwd(passwordEncoder.encode(userdto.getPwd()))
                .role(role)
                .build();

        userRepository.save(newUser);

        return true;

    }

    public boolean verifyUser(String pseudo, String password) {

        return userRepository.findByPseudo(pseudo)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("Invalid Id"));

    }

    public boolean checkUserPseudoExists(String pseudo) {
        return userRepository.findByPseudo(pseudo).isPresent();
    }


    public String generateToken(String pseudo, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(pseudo, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }

}

