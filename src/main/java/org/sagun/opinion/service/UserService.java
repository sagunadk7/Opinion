package org.sagun.opinion.service;

import org.sagun.opinion.dto.UserRegistrationRequestDTO;
import org.sagun.opinion.entity.Users;

import java.util.Optional;

public interface UserService {

    Users addUser(UserRegistrationRequestDTO user);
    Optional<Users>getUser(String username);
}
