/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.util;

import com.spring.framework.security.model.User;
import java.util.Random;

/**
 * @author root
 */
public class Transformer {
   
    public static User userParamsToUser(String username, String passowrd, 
            String organisation, String organisationType, String organisationId, String userType,
            String bankName, String bankImageUrl){
       User user = new User();
       user.setUsername(username);
       user.setPassword(passowrd);
       user.setOrganisation(organisation);
       user.setOrganisationType(organisationType);
       user.setOrganisationId(organisationId);
       user.setUserType(userType);
       user.setBankName(bankName);
       user.setBankImageUrl(bankImageUrl);
       return user;
    }
    
    public static String generateRandomKey(Integer size) {
        char[] chars = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMBOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
