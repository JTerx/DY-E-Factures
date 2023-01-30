package com.digitalyouthservices.efactures.services.authenticationService;

import com.digitalyouthservices.efactures.dto.TokenDto;
import com.digitalyouthservices.efactures.model.Login;
import com.digitalyouthservices.efactures.model.response.DataResponse;
import com.digitalyouthservices.efactures.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthenticationServiceImplementation(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }
    @Override
    public ResponseEntity<DataResponse<TokenDto>> Authenticate(Login loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        TokenDto token = new TokenDto();
        token.setToken(jwt);
        return new ResponseEntity<>(new DataResponse<>(token), HttpStatus.OK);
    }
}
