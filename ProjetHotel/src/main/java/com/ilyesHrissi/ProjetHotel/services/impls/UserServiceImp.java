package com.ilyesHrissi.ProjetHotel.services.impls;

import com.ilyesHrissi.ProjetHotel.mappers.UserMapper;
import com.ilyesHrissi.ProjetHotel.models.User;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.UserDTO;
import com.ilyesHrissi.ProjetHotel.repositories.UserRepository;
import com.ilyesHrissi.ProjetHotel.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public void updateUser(Long id, UserDTO userDTO) throws HttpException {
        User user = userRepository.findById(id).orElseThrow(() -> new HttpException("User not found", HttpStatus.NOT_FOUND));
        if (!userDTO.getEmail().equals(user.getEmail()) && userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new HttpException("Email already exists", HttpStatus.BAD_REQUEST);
        }
        userMapper.dtoToEntity(userDTO, user);
        userRepository.save(user);

    }

    @Override
    public UserDTO getUser(Long id) throws HttpException {
        return userMapper.entityToDto(userRepository.findById(id).orElseThrow(() -> new HttpException("User not found", HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.entitiesToDtos(userRepository.findAll());
    }
    public void deleteUser(Long id) throws HttpException {
        User user = userRepository.findById(id).orElseThrow(() -> new HttpException("User not found", HttpStatus.NOT_FOUND));
        userRepository.delete(user);
    }
    public void updateSelf(UserDTO userDTO, HttpServletRequest request) throws HttpException {
        User user = (User) request.getAttribute("user");
        if (userDTO.getId() != null && !userDTO.getId().equals(user.getId())) {
            throw new HttpException("You can't update other users", HttpStatus.FORBIDDEN);
        }
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        userRepository.save(user);

    }

}
