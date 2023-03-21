package com.digitalyouthfr.dyinvoice.service.implementation;

import com.digitalyouthfr.dyinvoice.exceptions.InvoiceApiException;
import com.digitalyouthfr.dyinvoice.models.Role;
import com.digitalyouthfr.dyinvoice.models.User;
import com.digitalyouthfr.dyinvoice.payload.LoginDto;
import com.digitalyouthfr.dyinvoice.payload.RegisterDto;
import com.digitalyouthfr.dyinvoice.repository.RoleRepository;
import com.digitalyouthfr.dyinvoice.repository.UserRepository;
import com.digitalyouthfr.dyinvoice.security.JwtTokenProvider;
import com.digitalyouthfr.dyinvoice.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
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
        try{
            if(userRepository.existsByUsername(registerDto.getUsername())){
                throw new InvoiceApiException(HttpStatus.BAD_REQUEST, "Username already registered");

            }

            if(userRepository.existsByEmail(registerDto.getEmail())){
                throw new InvoiceApiException(HttpStatus.BAD_REQUEST, "Email already registered");
            }

            User user = new User();
            user.setName(registerDto.getName());
            user.setUsername(registerDto.getUsername());
            user.setEmail(registerDto.getEmail());
            user.setCompanyName(registerDto.getCompanyName());
            user.setPhoneNumber(Long.valueOf(registerDto.getPhoneNumber()));
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

            Set<Role> roles = new HashSet<>();
            Optional<Role> userRoleOptional = roleRepository.findByName("ROLE_USER");

            if(userRoleOptional.isPresent()){
                Role userRole = userRoleOptional.get();
                roles.add(userRole);
            }else{
                throw new InvoiceApiException(HttpStatus.INTERNAL_SERVER_ERROR, "ROLE_USER not found");
            }

            // Ajout du code pour ajouter un utilisateur administrateur
            if (registerDto.getEmail().equals("admin@digitalyouthfr.com")) {
                Optional<Role> adminRoleOptional = roleRepository.findByName("ROLE_ADMIN");
                if(adminRoleOptional.isPresent()){
                    Role adminRole = adminRoleOptional.get();
                    roles.add(adminRole);
                }else{
                    throw new InvoiceApiException(HttpStatus.INTERNAL_SERVER_ERROR, "ROLE_ADMIN not found");
                }
            }

            user.setRoles(roles);
            userRepository.save(user);

            return "User registered successfully";

        }catch (Exception e){
            throw new InvoiceApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while registering user: " + e.getMessage());
        }

    }



}
