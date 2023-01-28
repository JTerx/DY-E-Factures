package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.ClientFacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientFacture, Long> {

}
