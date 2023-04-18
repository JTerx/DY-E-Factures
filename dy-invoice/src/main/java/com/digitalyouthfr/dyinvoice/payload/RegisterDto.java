package com.digitalyouthfr.dyinvoice.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private String name;
    private String email;
    private String username;
    private String companyName;
    private String phoneNumber;
    private String address;
    private String password;

}
