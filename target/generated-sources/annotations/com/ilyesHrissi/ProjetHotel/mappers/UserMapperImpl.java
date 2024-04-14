package com.ilyesHrissi.ProjetHotel.mappers;

import com.ilyesHrissi.ProjetHotel.enums.ERole;
import com.ilyesHrissi.ProjetHotel.models.User;
import com.ilyesHrissi.ProjetHotel.models.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-14T00:23:26+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public void entityToDto(User user, UserDTO userDTO) {
        if ( user == null ) {
            return;
        }

        if ( user.getId() != null ) {
            userDTO.setId( user.getId() );
        }
        if ( user.getEmail() != null ) {
            userDTO.setEmail( user.getEmail() );
        }
        if ( user.getFirstName() != null ) {
            userDTO.setFirstName( user.getFirstName() );
        }
        if ( user.getLastName() != null ) {
            userDTO.setLastName( user.getLastName() );
        }
        if ( user.getRole() != null ) {
            userDTO.setRole( user.getRole().name() );
        }
        userDTO.setLocked( user.isLocked() );
    }

    @Override
    public void dtoToEntity(UserDTO userDTO, User user) {
        if ( userDTO == null ) {
            return;
        }

        if ( userDTO.getId() != null ) {
            user.setId( userDTO.getId() );
        }
        if ( userDTO.getEmail() != null ) {
            user.setEmail( userDTO.getEmail() );
        }
        if ( userDTO.getFirstName() != null ) {
            user.setFirstName( userDTO.getFirstName() );
        }
        if ( userDTO.getLastName() != null ) {
            user.setLastName( userDTO.getLastName() );
        }
        if ( userDTO.getRole() != null ) {
            user.setRole( Enum.valueOf( ERole.class, userDTO.getRole() ) );
        }
        user.setLocked( userDTO.isLocked() );
    }

    @Override
    public User dtoToEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDTO.getId() );
        user.email( userDTO.getEmail() );
        user.firstName( userDTO.getFirstName() );
        user.lastName( userDTO.getLastName() );
        if ( userDTO.getRole() != null ) {
            user.role( Enum.valueOf( ERole.class, userDTO.getRole() ) );
        }
        user.locked( userDTO.isLocked() );

        return user.build();
    }

    @Override
    public UserDTO entityToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( user.getId() );
        userDTO.email( user.getEmail() );
        userDTO.firstName( user.getFirstName() );
        userDTO.lastName( user.getLastName() );
        if ( user.getRole() != null ) {
            userDTO.role( user.getRole().name() );
        }
        userDTO.locked( user.isLocked() );

        return userDTO.build();
    }

    @Override
    public List<UserDTO> entitiesToDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( entityToDto( user ) );
        }

        return list;
    }
}
