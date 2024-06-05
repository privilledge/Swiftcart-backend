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



    public User saveUser(User user){

        return userRepository.save(user);
    }
    public User findUserByEmail(String email){
        return  userRepository.findUserByEmail(email);
    }


    public List<User> getAllUsers(){
    return userRepository.findAll();
    }
}
