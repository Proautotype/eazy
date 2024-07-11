package com.sacred.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistException extends RuntimeException{
    public CategoryAlreadyExistException(String resourceName, String fieldName, String value){
        super(String.format("%s already with %s exist with value %s", resourceName, fieldName,value));
    }
}
