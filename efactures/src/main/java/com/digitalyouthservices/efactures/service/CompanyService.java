package com.digitalyouthservices.efactures.service;


import com.digitalyouthservices.efactures.dto.CompanyDto;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    CompanyDto createCompany(CompanyDto company);

    CompanyDto updateCompany(CompanyDto company, Long companyId);
}
