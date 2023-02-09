package com.digitalyouthservices.efactures.service;


import com.digitalyouthservices.efactures.dto.LoginDto;
import com.digitalyouthservices.efactures.dto.RegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);

}
