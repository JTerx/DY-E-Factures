package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company getCompanyByName(String name);
    Optional<Company> findByName(String name);
}
