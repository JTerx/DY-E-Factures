package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    List<UserAccount> findByEmail(String email);
}
