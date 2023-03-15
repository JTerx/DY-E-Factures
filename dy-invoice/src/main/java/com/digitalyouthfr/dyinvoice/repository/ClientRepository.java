package com.digitalyouthfr.dyinvoice.repository;


import com.digitalyouthfr.dyinvoice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
