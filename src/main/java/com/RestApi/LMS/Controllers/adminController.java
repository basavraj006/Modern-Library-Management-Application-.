package com.RestApi.LMS.Controllers;

import com.RestApi.LMS.module.Admin;
import com.RestApi.LMS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @PostMapping("/register")
    public Admin RegisterAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable("id") int AdminId){
        return adminService.deleteAdmin(AdminId);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Admin loginRequest){
        Map<String, Object> result = adminService.login(loginRequest.getMailId(),loginRequest.getPassword());
        return ResponseEntity.ok(result);
    }
}
