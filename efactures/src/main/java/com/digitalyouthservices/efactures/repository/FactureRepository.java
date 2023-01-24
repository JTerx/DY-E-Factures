package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<FactureEntity, Long> {

}
