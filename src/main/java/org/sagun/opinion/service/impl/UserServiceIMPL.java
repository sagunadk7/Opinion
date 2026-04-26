package org.sagun.opinion.service.impl;

import org.sagun.opinion.dto.UserRegistrationRequestDTO;
import org.sagun.opinion.entity.Users;
import org.sagun.opinion.repository.UserRepository;
import org.sagun.opinion.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceIMPL implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceIMPL(UserRepository repository , PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder= passwordEncoder;
    }

    @Override
    public Users addUser(UserRegistrationRequestDTO userRegistrationRequestDTO) {
        Users user = new Users();
        user.setUsername(userRegistrationRequestDTO.getUsername());
        user.setFirstName(userRegistrationRequestDTO.getFirstName());
        user.setLastName(userRegistrationRequestDTO.getLastName());
        user.setEmail(userRegistrationRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationRequestDTO.getPassword()));
        return repository.save(user);
    }

    @Override
    public Optional<Users>getUser(String username) {
       return repository.findByUsername(username);
    }
}
