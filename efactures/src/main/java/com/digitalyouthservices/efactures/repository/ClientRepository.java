package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.Client;
import com.digitalyouthservices.efactures.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByName(String name);
}
