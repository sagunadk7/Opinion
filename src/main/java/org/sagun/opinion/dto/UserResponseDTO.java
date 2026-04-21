package org.sagun.opinion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private String username;
    private String email;
    private String password;
    private String jwtToken;

}
