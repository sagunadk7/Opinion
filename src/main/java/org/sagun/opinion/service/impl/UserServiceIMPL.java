package org.sagun.opinion.service.impl;

import org.sagun.opinion.dto.UserRequestDTO;
import org.sagun.opinion.dto.UserResponseDTO;
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
    public Users addUser(UserRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setUsername(userRequestDTO.getUsername());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        return repository.save(user);
    }

    @Override
    public Optional<Users>getUser(String username) {
       return repository.findByUsername(username);
    }
}
