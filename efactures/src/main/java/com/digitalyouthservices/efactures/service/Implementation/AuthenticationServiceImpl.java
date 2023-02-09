package com.digitalyouthservices.efactures.service.Implementation;


import com.digitalyouthservices.efactures.dto.LoginDto;
import com.digitalyouthservices.efactures.dto.RegisterDto;
import com.digitalyouthservices.efactures.entity.Role;
import com.digitalyouthservices.efactures.entity.User;
import com.digitalyouthservices.efactures.exception.FactureApiException;
import com.digitalyouthservices.efactures.repository.RoleRepository;
import com.digitalyouthservices.efactures.repository.UserRepository;
import com.digitalyouthservices.efactures.security.JwtTokenProvider;
import com.digitalyouthservices.efactures.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;


    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {

        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new FactureApiException(HttpStatus.BAD_REQUEST, "Username already registered");

        }

        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new FactureApiException(HttpStatus.BAD_REQUEST, "Email already registered");
        }

        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));


        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
        //Faire un try catch pour la vérification de la création de l'utilisateur
        return "User registered successfully";
    }
}
