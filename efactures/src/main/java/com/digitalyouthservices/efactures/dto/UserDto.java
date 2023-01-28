package com.digitalyouthservices.efactures.dto;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public UserDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDto(){

    }
}
