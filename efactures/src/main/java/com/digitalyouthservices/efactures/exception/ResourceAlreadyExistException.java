package com.digitalyouthservices.efactures.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyExistException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private long fieldValue;


    public ResourceAlreadyExistException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // Post not found with id : 1
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceAlreadyExistException(String message, String resourceName) {
        super(message);
        this.resourceName = resourceName;

    }

    public ResourceAlreadyExistException(String message, Throwable cause, String resourceName) {
        super(message, cause);
        this.resourceName = resourceName;
    }



    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}
