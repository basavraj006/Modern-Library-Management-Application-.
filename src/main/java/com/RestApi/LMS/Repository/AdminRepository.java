package com.RestApi.LMS.Repository;

import com.RestApi.LMS.module.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByMailId(String mailId);
}
