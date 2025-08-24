package com.codingShuttle.LinkedIn.posts_service.exceptions;

public class EmptyContentException extends RuntimeException{
    public EmptyContentException(){
    }
    public EmptyContentException(String message){
        super(message);
    }
}
