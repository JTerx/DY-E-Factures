package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.PaiementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<PaiementEntity, Long> {
    
}
