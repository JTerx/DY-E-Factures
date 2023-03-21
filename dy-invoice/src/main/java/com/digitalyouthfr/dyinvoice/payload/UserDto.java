package com.digitalyouthfr.dyinvoice.payload;


import com.digitalyouthfr.dyinvoice.models.User;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String username;
    private String companyName;
    private Long phoneNumber;

    public UserDto(int id) {
        this.id = id;
    }

    public UserDto(User user) {
        this.id = Math.toIntExact(user.getId());
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.companyName = user.getCompanyName();
        this.phoneNumber = user.getPhoneNumber();
    }

}
