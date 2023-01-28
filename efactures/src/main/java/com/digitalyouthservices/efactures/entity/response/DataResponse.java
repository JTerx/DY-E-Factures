package com.digitalyouthservices.efactures.entity.response;

import lombok.Data;

@Data
public class DataResponse<T> {

    private T data;

    private String message;

    public DataResponse( String message) {
        this.data = null;
        this.message = message;
    }
    public DataResponse(T data) {
        this.data = data;
    }
}
