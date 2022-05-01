package insa.smart.smart_back.service.implementation;

import insa.smart.smart_back.dto.UserDTO;
import insa.smart.smart_back.entity.UserEntity;
import insa.smart.smart_back.exception.EmailExistsException;
import insa.smart.smart_back.repository.RoleRepository;
import insa.smart.smart_back.repository.UserRepository;
import insa.smart.smart_back.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;



    @Override
    public UserEntity registerNewUserAccount(UserDTO userDTO) {

        if (repository.existsByEmail(userDTO.getEmail())) {
            throw new EmailExistsException
                    ("There is an account with that email adress: " + userDTO.getEmail());
        }
        UserEntity user = new UserEntity();

        user.setUsername(userDTO.getUsername());
        user.setHashed_password(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setCreated_at(LocalDate.now());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));

        return repository.save(user);
    }
}
