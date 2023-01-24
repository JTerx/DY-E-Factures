package com.digitalyouthservices.efactures.services.userService;

import com.digitalyouthservices.efactures.dto.MeDTO;
import com.digitalyouthservices.efactures.dto.UserDTO;
import com.digitalyouthservices.efactures.entity.UserEntity;
import com.digitalyouthservices.efactures.model.response.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User {

    public abstract ResponseEntity<DataResponse<UserDTO>> createUser(UserEntity user);
    public abstract ResponseEntity<DataResponse<UserDTO>> deleteUser(int userId);
    public abstract ResponseEntity<DataResponse<UserDTO>> updateUser(int userId, UserEntity user);
    public abstract ResponseEntity<DataResponse<UserDTO>> getUserById(int userId);
    public abstract ResponseEntity<DataResponse<List<UserDTO>>> getAllUsers();

    public abstract ResponseEntity<DataResponse<MeDTO>> getMe(String userEmail, String companyName);


}
