package com.digitalyouthservices.efactures.services.authenticationService;

import com.digitalyouthservices.efactures.dto.TokenDto;
import com.digitalyouthservices.efactures.model.Login;
import com.digitalyouthservices.efactures.model.response.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    public abstract ResponseEntity<DataResponse<TokenDto>> Authenticate(Login loginRequest);
}
