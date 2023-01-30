package com.digitalyouthservices.efactures.dto;


public class RegisterDto {

    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String companyName;

    public RegisterDto(Long id, String firstName, String lastName, String email, String password, String companyName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.companyName = companyName;
    }
}
