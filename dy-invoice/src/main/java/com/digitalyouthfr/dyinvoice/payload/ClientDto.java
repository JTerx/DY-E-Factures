package com.digitalyouthfr.dyinvoice.payload;

import com.digitalyouthfr.dyinvoice.models.Client;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClientDto {
    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
    private String address;

    public ClientDto(Long id) {
        this.id = id;
    }


    public ClientDto(Client client) {
        this.name = client.getName();
        this.email = client.getEmail();
        this.phoneNumber = client.getPhoneNumber();
        this.address = client.getAddress();
    }
}
