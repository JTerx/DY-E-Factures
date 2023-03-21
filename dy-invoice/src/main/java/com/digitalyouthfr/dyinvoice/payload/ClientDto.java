package com.digitalyouthfr.dyinvoice.payload;

import com.digitalyouthfr.dyinvoice.models.Client;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClientDto {
    private int id;
    private String name;
    private String email;
    private Long phoneNumber;

    public ClientDto(int id) {
        this.id = id;
    }


    public ClientDto(Client client) {
        this.id = Math.toIntExact(client.getId());
        this.name = client.getName();
        this.email = client.getEmail();
        this.phoneNumber = client.getPhoneNumber();
    }
}
