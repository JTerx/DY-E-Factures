package com.digitalyouthservices.efactures.services.companyService;



import com.digitalyouthservices.efactures.entity.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    Company save(Company company);

    Company update(Company company);
}
