package com.digitalyouthservices.efactures.services.companyService;


import com.digitalyouthservices.efactures.entity.Company;
import com.digitalyouthservices.efactures.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImplementation implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        return null;
    }
}
