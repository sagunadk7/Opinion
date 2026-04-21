package org.sagun.opinion.controller;

import org.sagun.opinion.dto.UserRequestDTO;
import org.sagun.opinion.entity.Users;
import org.sagun.opinion.jwtutils.JWTUtils;
import org.sagun.opinion.mapper.UserMapper;
import org.sagun.opinion.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    public ResponseEntity<?> singIn(@RequestBody UserRequestDTO userRequestDTO) {
        if(service.getUser(userRequestDTO.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already Exist.");
        }
        Users user;
        try {
            user = service.addUser(userRequestDTO);
        } catch (DataIntegrityViolationException e) {
            // Catches race condition where two requests pass the check simultaneously
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Username already exists.");
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequestDTO.getUsername(),userRequestDTO.getPassword()));
        } catch (Exception e) {
            System.out.println("Error Occured");
            throw e;
        }
        String token = jwtUtils.generateJwt(user.getUsername());
        return ResponseEntity.ok(token);
    }
}
