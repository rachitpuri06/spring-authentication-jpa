package com.spring.framework.service;

import com.spring.framework.security.exception.UserRegistrationException;
import com.spring.framework.security.model.Authority;
import com.spring.framework.security.model.User;
import com.spring.framework.security.repository.AuthorityRepository;
import com.spring.framework.security.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author rachit
 */
@Service
public class UserDataService {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    
    public User getUserFromUsername(String username) throws UserRegistrationException{
        List<User> users =userRepository.findByUsername(username);
        if(!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
    
    public void saveUser(User user){
        userRepository.save(user);
    }
    
    public void saveAuthority(Authority authority){
        authorityRepository.save(authority);
    }
}
