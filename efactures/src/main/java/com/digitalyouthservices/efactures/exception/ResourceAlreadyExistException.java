package com.digitalyouthservices.efactures.exception;

public class ResourceAlreadyExistException extends RuntimeException{

    public ResourceAlreadyExistException(final String resourceName, String fieldName) {
        super(String.format("%s already exists with %s : '%s'", resourceName, fieldName));
    }
}
