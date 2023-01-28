package com.digitalyouthservices.efactures.services.userService;

import com.digitalyouthservices.efactures.entity.UserAccount;
import com.digitalyouthservices.efactures.exception.ResourceAlreadyExistException;
import com.digitalyouthservices.efactures.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserAccount save(UserAccount account) {
        Optional<UserAccount> currentUser = userRepository.findById(account.getId());
        if(!currentUser.isPresent()) {
            userRepository.save(account);
        }
             throw new ResourceAlreadyExistException("User ", account.getFirstName() + " already exists");
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
