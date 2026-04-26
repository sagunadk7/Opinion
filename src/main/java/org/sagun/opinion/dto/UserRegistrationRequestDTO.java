package org.sagun.opinion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationRequestDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
