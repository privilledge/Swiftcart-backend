package com.privilledge.backend_ecommerce.service;

import com.privilledge.backend_ecommerce.model.User;
import com.privilledge.backend_ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public PasswordEncoder getPasswordEncoder() {
//        return passwordEncoder;
//    }

//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;


    public User saveUser(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User findUserByEmail(String email){
        return  userRepository.findUserByEmail(email);
    }


    public List<User> getAllUsers(){
    return userRepository.findAll();
    }
}
