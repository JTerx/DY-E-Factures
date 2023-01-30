package com.digitalyouthservices.efactures.services.userService;

import com.digitalyouthservices.efactures.dto.RegisterDto;
import com.digitalyouthservices.efactures.entity.Company;
import com.digitalyouthservices.efactures.entity.UserAccount;
import com.digitalyouthservices.efactures.repository.CompanyRepository;
import com.digitalyouthservices.efactures.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserAccount save(RegisterDto account) {
        Company company = new Company();
        company.setName(account.companyName);
        companyRepository.save(company);

        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(account.firstName);
        userAccount.setLastName(account.lastName);
        userAccount.setEmail(account.email);
        userAccount.setPassword(passwordEncoder.encode(account.password));
        userAccount.setCompany(company);

       return userRepository.save(userAccount);
    }
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<UserAccount> findAll() {
        return userRepository.findAll();
    }
    @Override
    public Optional<UserAccount> findById(Long id) {
        return userRepository.findById(id);
    }



}
