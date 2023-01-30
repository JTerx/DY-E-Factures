package com.digitalyouthservices.efactures.controller;

import com.digitalyouthservices.efactures.dto.RegisterDto;
import com.digitalyouthservices.efactures.dto.TokenDto;
import com.digitalyouthservices.efactures.dto.UserDto;
import com.digitalyouthservices.efactures.entity.Company;
import com.digitalyouthservices.efactures.entity.UserAccount;
import com.digitalyouthservices.efactures.model.Login;
import com.digitalyouthservices.efactures.model.Register;
import com.digitalyouthservices.efactures.model.response.DataResponse;
import com.digitalyouthservices.efactures.services.authenticationService.AuthenticationService;
import com.digitalyouthservices.efactures.services.companyService.CompanyService;
import com.digitalyouthservices.efactures.services.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path= "/api/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final CompanyService companyService;
    private final AuthenticationService authenticationService;

    @PostMapping(path= "/login")
    public ResponseEntity<DataResponse<TokenDto>> authenticateUser(@Valid @RequestBody Login loginRequest){
        return authenticationService.Authenticate(loginRequest);
    }

    @PostMapping(path= "/Register")
    public ResponseEntity<DataResponse<Dto>> registerUser(@RequestBody Register register){



    }

}
