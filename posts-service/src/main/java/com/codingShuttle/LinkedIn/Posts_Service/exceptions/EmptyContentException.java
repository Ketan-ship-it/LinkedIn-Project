package com.codingShuttle.LinkedIn.Posts_Service.exceptions;

public class EmptyContentException extends RuntimeException{
    public EmptyContentException(){
    }
    public EmptyContentException(String message){
        super(message);
    }
}
