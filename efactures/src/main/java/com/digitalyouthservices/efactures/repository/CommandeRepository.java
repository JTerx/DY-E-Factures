package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
