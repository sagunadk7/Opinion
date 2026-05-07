package org.sagun.opinion.service.impl;

import org.sagun.opinion.dto.UserChangePasswordRequestDTO;
import org.sagun.opinion.dto.UserRegistrationRequestDTO;
import org.sagun.opinion.entity.Users;
import org.sagun.opinion.repository.UserRepository;
import org.sagun.opinion.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public String changePassword(UserChangePasswordRequestDTO changePasswordRequestDTO){
        System.out.println("-------------------------------");
        System.out.println("username "+ changePasswordRequestDTO.getCurrentPassword());
        System.out.println("oldPassword "+ changePasswordRequestDTO.getCurrentPassword());
        System.out.println("newPassword "+ changePasswordRequestDTO.getNewPassword());
        System.out.println("-------------------------------");
        Users users = repository.findByUsername(changePasswordRequestDTO.getUsername()).orElseThrow(()->new RuntimeException("User not found."));
        if(!passwordEncoder.matches(changePasswordRequestDTO.getCurrentPassword(),users.getPassword())){
            return "Wrong old password";
        }
        users.setPassword(passwordEncoder.encode(changePasswordRequestDTO.getNewPassword()));
        repository.save(users);
        return "Password changed Successfully";
    }
}
