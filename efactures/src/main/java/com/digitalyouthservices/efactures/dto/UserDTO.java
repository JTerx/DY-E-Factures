package com.digitalyouthservices.efactures.dto;

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private CompanyDTO company;

    public UserDTO(Long id, String firstName, String lastName, String email, Integer phone, CompanyDTO company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }


    public UserDTO() {

    }
}
