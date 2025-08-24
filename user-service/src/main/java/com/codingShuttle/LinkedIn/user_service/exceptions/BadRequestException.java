package com.codingShuttle.LinkedIn.user_service.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){}
    public BadRequestException(String message){
        super(message);
    }
}
