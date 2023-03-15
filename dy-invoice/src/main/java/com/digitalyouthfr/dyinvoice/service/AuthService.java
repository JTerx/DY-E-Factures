package com.digitalyouthfr.dyinvoice.service;

import com.digitalyouthfr.dyinvoice.payload.LoginDto;
import com.digitalyouthfr.dyinvoice.payload.RegisterDto;
import org.springframework.stereotype.Service;


@Service
public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
