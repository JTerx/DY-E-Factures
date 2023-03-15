package com.digitalyouthfr.dyinvoice.payload;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String companyName;
    private int phoneNumber;

}
