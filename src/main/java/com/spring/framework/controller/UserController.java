package com.spring.framework.controller;

import com.spring.framework.dto.ResultDTO;
import com.spring.framework.security.exception.UserRegistrationException;
import com.spring.framework.security.model.User;
import com.spring.framework.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author rachit
 */

@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/register" , method = RequestMethod.POST )
    public ResultDTO register(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "username") String username, 
            @RequestParam(value = "password") String password,
            @RequestParam(value = "organisation" , required = false, defaultValue = "BANK") String organisation, // PAYU or BANK
            @RequestParam(value = "organisationType") String orgnaisationType, // CARD or NB
            @RequestParam(value = "organisationId") String organisationId,  // Pg_id that is eligible 
            @RequestParam(value = "userType") String userType,  //ADMMIN or SUPERADMIN
            @RequestParam(value = "bankName") String bankName,
            @RequestParam(value = "bankImageUrl") String bankImageUrl) throws UserRegistrationException{
      User user = userService.registerUser(username, password, organisation, orgnaisationType, 
              organisationId, userType, bankName, bankImageUrl);
      return new ResultDTO(0, user);
    }
    
    @RequestMapping(value ="/admin/authority" , method = RequestMethod.POST)
    public ResultDTO addAuthority(HttpServletRequest request,HttpServletResponse response,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "authority") String authroity ){
        userService.addRoles(username, authroity);
        return new ResultDTO(0,"Role added");
    }
            
}
