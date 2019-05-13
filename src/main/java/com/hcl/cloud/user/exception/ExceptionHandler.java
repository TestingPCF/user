/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.hcl.cloud.user.DTO.ExceptionResponseDTO;
import com.hcl.cloud.user.constant.UserConstant;

/**
 * com.hcl.cloud.user.exception abhishek_sin
 */
@ControllerAdvice
@RefreshScope
public class ExceptionHandler {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    
    
    @Value("${user.already.msg}")
    private  String ERROR_MESSAGE;
    /**
     *
     *
     * @param request
     *            for HTTP.
     * @param exception
     *            for Exception .
     * @return tag for Response.
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleError(HttpServletRequest request, Exception exception) {
        final ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO();
        
        if(exception instanceof  DataIntegrityViolationException) {
        	 exceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());
             exceptionResponse.setDescription(ERROR_MESSAGE);
        } 
        else {
        exceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionResponse.setDescription(exception.getMessage());
        }
        logger.error("Error " + exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
