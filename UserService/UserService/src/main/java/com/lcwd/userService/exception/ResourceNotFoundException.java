package com.lcwd.userService.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource not founnd ");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
