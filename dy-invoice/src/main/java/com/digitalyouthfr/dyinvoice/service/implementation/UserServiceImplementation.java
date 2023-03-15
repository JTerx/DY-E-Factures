package com.digitalyouthfr.dyinvoice.service.implementation;

import com.digitalyouthfr.dyinvoice.models.Role;
import com.digitalyouthfr.dyinvoice.models.User;
import com.digitalyouthfr.dyinvoice.repository.RoleRepository;
import com.digitalyouthfr.dyinvoice.repository.UserRepository;
import com.digitalyouthfr.dyinvoice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.HashSet;

@Service
public class UserServiceImplementation implements UserService {

    @PersistenceUnit
    private EntityManagerFactory emf;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

/*    public void createDefaultAdmin() {
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("admin"));

        Role role = new Role();
        role.setName("ROLE_ADMIN");

        user.setRoles(new HashSet<>());
        user.getRoles().add(role);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(role);
        em.persist(user);

        em.getTransaction().commit();
        em.close();
    }*/
}
