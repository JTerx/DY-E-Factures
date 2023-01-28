package com.digitalyouthservices.efactures.services.userService;


import com.digitalyouthservices.efactures.entity.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    UserAccount save(UserAccount account);

    void deleteById(Long id);

    List<UserAccount> findAll();

    Optional<UserAccount> findById(Long id);








}
