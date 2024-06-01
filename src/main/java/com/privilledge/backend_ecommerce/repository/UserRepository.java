package com.privilledge.backend_ecommerce.repository;

import com.privilledge.backend_ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
    List<User> findAll();
}
