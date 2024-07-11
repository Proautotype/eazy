package com.sacred.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class RequestFormulationException extends RuntimeException{
    public RequestFormulationException(String resource, String body, Object value){
        super(String.format("Resource %s is not available in %s, data is currently %s ",resource, body, value));
    }
}
