/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.security.repository;

import com.spring.framework.security.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rachit
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    List<User> findByUsername(String username);
}
