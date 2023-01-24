package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByEmail(String email);
}
