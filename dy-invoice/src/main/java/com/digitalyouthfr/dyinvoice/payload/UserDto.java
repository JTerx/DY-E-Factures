package com.digitalyouthfr.dyinvoice.payload;


import com.digitalyouthfr.dyinvoice.models.User;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String companyName;
    private String address;
    private Long phoneNumber;


    public UserDto(Long id) {
        this.id = id;
    }

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.companyName = user.getCompanyName();
        this.address = user.getAddress();
        this.phoneNumber = user.getPhoneNumber();

    }

}
