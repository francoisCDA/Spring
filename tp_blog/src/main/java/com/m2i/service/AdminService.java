package com.m2i.service;

import com.m2i.entity.Administrator;
import com.m2i.repository.AdminRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    private final HttpSession _httpSession;


    public boolean isAdminExist() {
        long nbAdmin = adminRepository.count();
        return nbAdmin != 0;
    }

    public boolean identification(String username, String password) {
        long nbAdmin = adminRepository.countByAdminNameAndPassword(username,password);
        _httpSession.setAttribute("admin",true);
        return nbAdmin == 1;
    }

    public boolean isAdminConnected(){
        try {
            return (boolean) _httpSession.getAttribute("admin");
        } catch (Exception ex) {
            return false;
        }
    }

    public void disconnect() {
        _httpSession.removeAttribute("admin");
    }

    public boolean newAdmin(String username, String password) {
        if (identification(username,password)) return true;
        if (!isAdminExist()) {
            adminRepository.save(new Administrator(username, password));
            return true;
        }
        return false;
    }




}
