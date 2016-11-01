/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.security.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rachit
 */
@Entity
@Table(name = "authorities")
public class Authority implements Serializable{
  
  @Id
  @Column(name="id")
  @GeneratedValue
  private Long id;  
  
  @Column(name = "username")
  private String username;
  
  
  @Column(name = "authority")
  private String authority;

  @Column(name = "groupsId", columnDefinition="int(11) default -1")
  private Integer groupsId = -1;
  
  public Authority(String username, String authority) {
    this.username = username;
    this.authority = authority;
  }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(Integer groupsId) {
        this.groupsId = groupsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
  
  
  
    
}
