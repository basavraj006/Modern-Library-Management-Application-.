package com.RestApi.LMS.Repository;

import com.RestApi.LMS.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
