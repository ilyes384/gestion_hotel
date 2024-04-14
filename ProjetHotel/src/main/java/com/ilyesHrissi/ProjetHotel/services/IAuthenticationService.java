package com.ilyesHrissi.ProjetHotel.services;

import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.LoginDTO;
import com.ilyesHrissi.ProjetHotel.models.dto.LoginResponseDTO;
import com.ilyesHrissi.ProjetHotel.models.dto.SignupDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginDTO loginDTO) throws HttpException;
    void signup(SignupDTO signupDTO) throws HttpException;
}
