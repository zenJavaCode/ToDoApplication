package com.codeRoots.ToDoApplication.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {

        super(message);
    }

    public ResourceNotFoundException(){
        super("Resource not found.");
    }
}
