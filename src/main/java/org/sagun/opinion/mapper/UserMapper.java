package org.sagun.opinion.mapper;


import org.sagun.opinion.dto.UserResponseDTO;
import org.sagun.opinion.entity.Users;

public class UserMapper {

    public static  UserResponseDTO toResponse(Users user) {
        return new UserResponseDTO(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                null
        );
    }

}
