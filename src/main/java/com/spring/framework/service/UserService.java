/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.service;

import com.spring.framework.security.exception.UserRegistrationException;
import com.spring.framework.security.model.Authority;
import com.spring.framework.security.model.User;
import com.spring.framework.util.Transformer;
import com.spring.framework.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author rachit
 */
@Service
public class UserService {

    @Autowired
    MessageDigestPasswordEncoder passwordEncoder;
    @Autowired
    UserDataService userDataService;

    public User registerUser(String username, String passowrd,
            String organisation, String organisationType, String organisationId, String userType,
            String bankName, String bankImageUrl) throws UserRegistrationException {
        this.validation(username, passowrd);
        User user = Transformer.userParamsToUser(username, passowrd, organisation,
                organisationType, organisationId, userType, bankName, bankImageUrl);
        user.setSalt(Transformer.generateRandomKey(8));
        user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getSalt()));
        userDataService.saveUser(user);
        return user;
        
    }
    
    public void addRoles(String username, String authorit){
        Authority authority = new Authority(username, authorit);
        userDataService.saveAuthority(authority);        
    }

    private void validation(String username, String password) throws UserRegistrationException {
        if (!Validator.email(username)) {
            throw new UserRegistrationException("email not valid");
        }
        if (!Validator.password(password)) {
            throw new UserRegistrationException("password not valid");
        }
        if (userDataService.getUserFromUsername(username) != null) {
            throw new UserRegistrationException("username already taken");
        }
    }


}
