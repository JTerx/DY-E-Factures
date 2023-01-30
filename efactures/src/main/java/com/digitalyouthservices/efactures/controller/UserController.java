package com.digitalyouthservices.efactures.controller;


import com.digitalyouthservices.efactures.dto.RegisterDto;
import com.digitalyouthservices.efactures.entity.Company;
import com.digitalyouthservices.efactures.entity.UserAccount;
import com.digitalyouthservices.efactures.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserAccount> createUserAccount(@RequestBody RegisterDto account) {
        System.err.println(account);
        return ResponseEntity.ok(userService.save(account));
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserAccount>> findById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
