package com.digitalyouthfr.dyinvoice.service;

import com.digitalyouthfr.dyinvoice.payload.FactureDto;
import com.digitalyouthfr.dyinvoice.payload.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUserById(Long id);

    List<FactureDto> getFacturesByUserId(Long userId);
}
