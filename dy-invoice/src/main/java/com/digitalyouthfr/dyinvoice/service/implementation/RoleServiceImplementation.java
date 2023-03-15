package com.digitalyouthfr.dyinvoice.service.implementation;

import com.digitalyouthfr.dyinvoice.models.Role;
import com.digitalyouthfr.dyinvoice.repository.RoleRepository;
import com.digitalyouthfr.dyinvoice.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImplementation(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void createDefaultRoles() {
        if (!roleRepository.findByName("ROLE_USER").isPresent()) {
            Role role = new Role();
            role.setName("ROLE_USER");
            roleRepository.save(role);
        }

        if(!roleRepository.findByName("ROLE_ADMIN").isPresent()){
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            roleRepository.save(role);
        }
    }


}