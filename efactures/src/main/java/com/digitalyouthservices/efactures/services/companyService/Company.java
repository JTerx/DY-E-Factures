package com.digitalyouthservices.efactures.services.companyService;

import com.digitalyouthservices.efactures.dto.ClientDTO;
import com.digitalyouthservices.efactures.dto.CompanyDTO;
import com.digitalyouthservices.efactures.entity.ClientEntity;
import com.digitalyouthservices.efactures.entity.CompanyEntity;
import com.digitalyouthservices.efactures.model.response.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface Company {

    public abstract ResponseEntity<DataResponse<CompanyDTO>> createCompany(CompanyEntity client);
    public abstract ResponseEntity<DataResponse<CompanyDTO>> updateCompany(int companyId, CompanyEntity client);
}
