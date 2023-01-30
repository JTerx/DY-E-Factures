package com.digitalyouthservices.efactures.dto;

public class CompanyDto {

    public Long id;
    public String name;
    public UserDto user;

    public CompanyDto(Long id, String name, UserDto user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public CompanyDto() {
    }
}
