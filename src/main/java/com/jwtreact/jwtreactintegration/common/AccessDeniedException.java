package com.jwtreact.jwtreactintegration.common;

public class AccessDeniedException extends RuntimeException{
    
    public AccessDeniedException(String message){
        super(message);
    }
    
}
