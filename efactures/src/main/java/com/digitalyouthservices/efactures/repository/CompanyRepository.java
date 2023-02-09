package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company getCompanyByName(String name);
    Optional<Company> findByName(String name);
}
