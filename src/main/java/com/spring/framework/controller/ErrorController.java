/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.controller;

import com.spring.framework.dto.ResultDTO;
import com.spring.framework.security.exception.UserRegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author rachit
 */
@ControllerAdvice
@ResponseStatus(value = HttpStatus.OK)
@ResponseBody
public class ErrorController {

    @ExceptionHandler(UserRegistrationException.class)
    public ResultDTO HandleReportExecutionException(UserRegistrationException ex) {
        //String guid = String.valueOf(MDC.get("guid"));
        //   log.error("Error occurred while executing report " , ex.getMessage());
        return new ResultDTO(-1,ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultDTO handleAllExceptions(Exception ex) {
        //String guid = String.valueOf(MDC.get("guid"));
        // log.error("Something went wrong: " + guid ,ex);
        return new ResultDTO(-1, "Something went wrong");
    }
}
