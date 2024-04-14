package com.ilyesHrissi.ProjetHotel.mappers;

import com.ilyesHrissi.ProjetHotel.models.User;
import com.ilyesHrissi.ProjetHotel.models.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy= org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    void entityToDto(User user, @MappingTarget UserDTO userDTO);
    void dtoToEntity(UserDTO userDTO, @MappingTarget User user);
    User dtoToEntity(UserDTO userDTO);
    UserDTO entityToDto(User user);
    List<UserDTO> entitiesToDtos(List<User> users);

}
