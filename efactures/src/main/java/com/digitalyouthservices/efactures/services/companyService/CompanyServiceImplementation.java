package com.digitalyouthservices.efactures.services.companyService;


import com.digitalyouthservices.efactures.entity.Company;
import com.digitalyouthservices.efactures.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company save(Company company) {
        Optional<Company> currentCompany = companyRepository.findByName(Company.class.getName());
        Optional<Company> currentCompanyId = companyRepository.findById(company.getId());
        if(!currentCompany.isPresent() && !currentCompanyId.isPresent()) {
            companyRepository.save(company);
        }
        throw new ResourceNotFoundException("Company doesn't exist " + company);
    }

    @Override
    public Company update(Company company) {
        return null;
    }

    @Override
    public Optional<Company> findCompanyByName(String companyName) {
        return companyRepository.findByName(companyName);
    }


}
