package com.digitalyouthfr.dyinvoice.exceptions;

public class ClientExistException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private long fieldValue;

    public ClientExistException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // Post not found with id : 1
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ClientExistException(String message, String resourceName) {
        super(message);
        this.resourceName = resourceName;

    }

    public ClientExistException(String message, Throwable cause, String resourceName) {
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
