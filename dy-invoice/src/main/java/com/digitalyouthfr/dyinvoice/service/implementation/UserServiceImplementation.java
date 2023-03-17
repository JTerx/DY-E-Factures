package com.digitalyouthfr.dyinvoice.service.implementation;

import com.digitalyouthfr.dyinvoice.exceptions.ResourceNotFoundException;
import com.digitalyouthfr.dyinvoice.exceptions.UserExistException;
import com.digitalyouthfr.dyinvoice.models.Facture;
import com.digitalyouthfr.dyinvoice.models.Role;
import com.digitalyouthfr.dyinvoice.models.User;
import com.digitalyouthfr.dyinvoice.payload.FactureDto;
import com.digitalyouthfr.dyinvoice.payload.UserDto;
import com.digitalyouthfr.dyinvoice.repository.RoleRepository;
import com.digitalyouthfr.dyinvoice.repository.UserRepository;
import com.digitalyouthfr.dyinvoice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @PersistenceUnit
    private EntityManagerFactory emf;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map((user) -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user" , "id", id));

        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        Optional<User> currentUser = userRepository.findByEmail(user.getEmail());
        if(!currentUser.isPresent()){
            User saveUser = userRepository.save(user);
            return mapper.map(saveUser, UserDto.class);
        }else {
            throw new UserExistException("User Already Exist", user.getEmail());
        }
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userRepository.delete(user);
    }

    @Override
    public List<FactureDto> getFacturesByUserId(Long userId) {

        User user  = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found", "id", userId));

        List<Facture> factures = user.getFactures()
                .stream()
                .collect(Collectors.toList());

        return factures.stream().map(facture -> mapper.map(facture, FactureDto.class))
                .collect(Collectors.toList());
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
