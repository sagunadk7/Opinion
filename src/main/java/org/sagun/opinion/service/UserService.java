package org.sagun.opinion.service;

import org.sagun.opinion.dto.UserRequestDTO;
import org.sagun.opinion.dto.UserResponseDTO;
import org.sagun.opinion.entity.Users;

import java.util.Optional;

public interface UserService {

    Users addUser(UserRequestDTO user);
    Optional<Users>getUser(String username);
}
