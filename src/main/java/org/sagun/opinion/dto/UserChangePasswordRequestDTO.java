package org.sagun.opinion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserChangePasswordRequestDTO {
    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;
}
