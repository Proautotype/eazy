package com.eazybytes.cards.exceptions;

public class CardAlreadyExistException extends RuntimeException{
    public CardAlreadyExistException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s already exist by field %s : '%s' ", resourceName, fieldName, fieldValue));
    }
}
