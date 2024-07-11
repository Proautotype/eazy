package com.sacred.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class InventoryAlreadyExistException extends RuntimeException{
    public InventoryAlreadyExistException(String message){
        super(message);
    }
}
