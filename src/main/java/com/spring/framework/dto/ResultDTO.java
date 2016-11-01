/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.dto;

/**
 * @author rachit
 */
public class ResultDTO {
    
    private Integer status;
    
    private Object result;
    
    private String message;
    
    
    public ResultDTO(Integer status, Object result, String message){
        this.status = status;
        this.result = result;
        this.message = message;
    }
    
        public ResultDTO(Integer status, Object result){
        this.status = status;
        this.result = result;
        this.message = message;
    }
    

           
}
