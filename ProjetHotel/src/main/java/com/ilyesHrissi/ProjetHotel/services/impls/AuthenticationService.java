package com.ilyesHrissi.ProjetHotel.services.impls;

import com.ilyesHrissi.ProjetHotel.config.JwtUtil;
import com.ilyesHrissi.ProjetHotel.enums.ERole;
import com.ilyesHrissi.ProjetHotel.models.User;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.LoginDTO;
import com.ilyesHrissi.ProjetHotel.models.dto.LoginResponseDTO;
import com.ilyesHrissi.ProjetHotel.models.dto.SignupDTO;
import com.ilyesHrissi.ProjetHotel.repositories.UserRepository;
import com.ilyesHrissi.ProjetHotel.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO) throws HttpException{
        User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new HttpException("User not found", HttpStatus.NOT_FOUND));
        if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
            throw new HttpException("Invalid credentials", HttpStatus.BAD_REQUEST);
        }
        return LoginResponseDTO.builder().token(jwtUtil.generateToken(user)).role(user.getRole()).build();
    }

    @Override
    public void signup(SignupDTO signupDTO) throws HttpException {
        User user = userRepository.findByEmail(signupDTO.getEmail()).orElse(null);
        if(user != null){
            throw new HttpException("User already exists", HttpStatus.BAD_REQUEST);
        }

        User newUser = User.builder()
                .email(signupDTO.getEmail())
                .password(passwordEncoder.encode(signupDTO.getPassword()))
                .role(ERole.USER)
                .firstName(signupDTO.getFirstName())
                .lastName(signupDTO.getLastName())
                .locked(false)
                .build();
        userRepository.save(newUser);
    }
}
