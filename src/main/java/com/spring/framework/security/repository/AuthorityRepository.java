/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.security.repository;

import com.spring.framework.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author root
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{
    
}
