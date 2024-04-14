package com.ilyesHrissi.ProjetHotel.controllers;


import com.ilyesHrissi.ProjetHotel.models.dto.*;
import com.ilyesHrissi.ProjetHotel.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<CommonMessageResponseDTO> register(@RequestBody SignupDTO signupDTO) throws HttpException {
        authenticationService.signup(signupDTO);
        return ResponseEntity.ok(CommonMessageResponseDTO.builder().message("User registered successfully").build());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) throws HttpException {
        return ResponseEntity.ok(authenticationService.login(loginDTO));
    }
}
