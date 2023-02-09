package com.digitalyouthservices.efactures.service.Implementation;

import com.digitalyouthservices.efactures.dto.CompanyDto;
import com.digitalyouthservices.efactures.entity.Company;
import com.digitalyouthservices.efactures.exception.ResourceAlreadyExistException;
import com.digitalyouthservices.efactures.exception.ResourceNotFoundException;
import com.digitalyouthservices.efactures.repository.CompanyRepository;
import com.digitalyouthservices.efactures.service.CompanyService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class CompanyServiceImplementation implements CompanyService {

    private final CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CompanyServiceImplementation(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = modelMapper.map(companyDto, Company.class);
        Optional<Company> currentCompany = companyRepository.findByName(company.getName());
        if(!currentCompany.isPresent()) {
            Company saveCompany = companyRepository.save(company);
            return modelMapper.map(saveCompany, CompanyDto.class);
        }

        throw new ResourceAlreadyExistException("Company already exists", company.getName());
    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company","id: ", companyId));

        company.setName(companyDto.getName());
        company.setId(companyDto.getId());

        Company updateCompany = companyRepository.save(company);

        return modelMapper.map(updateCompany, CompanyDto.class);
    }
}
