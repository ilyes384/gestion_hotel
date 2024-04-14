package com.ilyesHrissi.ProjetHotel.services;

import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface IUserService {
    void updateUser(Long id, UserDTO userDTO) throws HttpException;
    public UserDTO getUser(Long id) throws HttpException;
    List<UserDTO> getAllUsers();
    void deleteUser(Long id) throws HttpException;
    void updateSelf(UserDTO userDTO, HttpServletRequest request) throws HttpException;
}
