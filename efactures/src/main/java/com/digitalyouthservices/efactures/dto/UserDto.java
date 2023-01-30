package com.digitalyouthservices.efactures.dto;

public class UserDto {

    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public CompanyDto company;

    public UserDto(Long id, String firstName, String lastName, String email, CompanyDto company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
    }

    public UserDto(){

    }
}
