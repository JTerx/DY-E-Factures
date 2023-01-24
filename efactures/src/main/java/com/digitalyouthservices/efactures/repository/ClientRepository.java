package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
