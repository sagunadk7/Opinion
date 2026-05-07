package org.sagun.opinion.controller.authcontroller;

import org.sagun.opinion.dto.UserChangePasswordRequestDTO;
import org.sagun.opinion.dto.UserRegistrationRequestDTO;
import org.sagun.opinion.dto.UserResponseDTO;
import org.sagun.opinion.entity.Users;
import org.sagun.opinion.jwtutils.JWTUtils;
import org.sagun.opinion.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/users")
public class UserController {

    private final JWTUtils jwtUtils;
    private final UserService service;
    private final AuthenticationManager authenticationManager;

    public UserController(JWTUtils jwtUtils, UserService service, PasswordEncoder encoder, AuthenticationManager authenticationManager) {
        this.jwtUtils=jwtUtils;
        this.service=service;
        this.authenticationManager=authenticationManager;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> signIn(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO) {
        if(service.getUser(userRegistrationRequestDTO.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("User already Exist.");
        }
        Users user;
        try {
            user = service.addUser(userRegistrationRequestDTO);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Enter all the field.");
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRegistrationRequestDTO.getUsername(), userRegistrationRequestDTO.getPassword()));
        } catch (Exception e) {
            System.out.println("Error Occurred");
            throw e;
        }
        String token = jwtUtils.generateJwt(user.getUsername());
        UserResponseDTO response = new UserResponseDTO(token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestBody UserChangePasswordRequestDTO userChangePasswordRequestDTO){
        System.out.println("-------------------------------");
        System.out.println("username "+ userChangePasswordRequestDTO.getCurrentPassword());
        System.out.println("oldPassword "+ userChangePasswordRequestDTO.getCurrentPassword());
        System.out.println("newPassword "+ userChangePasswordRequestDTO.getNewPassword());
        System.out.println("-------------------------------");
        return service.changePassword(userChangePasswordRequestDTO);
    }

}
