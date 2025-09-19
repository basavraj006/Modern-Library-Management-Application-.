package com.RestApi.LMS.service;

import com.RestApi.LMS.Repository.AdminRepository;
import com.RestApi.LMS.module.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Admin> getAllAdmin(){
        return adminRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Admin saveAdmin(Admin admin){
        String EncodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(EncodedPassword);
        return adminRepository.save(admin);
    }

    public String deleteAdmin(int id){
        adminRepository.deleteById(id);
        return "Admin with the id "+id+" is deleted succesfully";
    }

    public Map<String, Object> login (String MailId, String rawPassword){
        Map<String,Object> response= new HashMap<>();
        Admin admin = adminRepository.findByMailId(MailId);


        if (admin==null){
            response.put("success",false);
            response.put("message","Admin not found");
            return response;
        }
        if (passwordEncoder.matches(rawPassword,admin.getPassword())){
            response.put("success",true);
            response.put("message","Admin login succesfull");
            response.put("AdminId",admin.getId());
            response.put("mailId",admin.getMailId());
        }else {
            response.put("success",false);
            response.put("message","Login failed invalid password or mail Id");
        }
        return response;
    }

}
