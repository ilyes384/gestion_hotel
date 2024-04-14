package com.ilyesHrissi.ProjetHotel.mappers;

import com.ilyesHrissi.ProjetHotel.models.Room;
import com.ilyesHrissi.ProjetHotel.models.dto.RoomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy= org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface RoomMapper {
    void entityToDto(Room room, @MappingTarget RoomDTO roomDTO);
    void dtoToEntity(RoomDTO roomDTO, @MappingTarget Room room);
    Room dtoToEntity(RoomDTO roomDTO);
    RoomDTO entityToDto(Room room);
    List<RoomDTO> entitiesToDtos(List<Room> rooms);
    List<Room> dtosToEntities(List<RoomDTO> roomDTOS);
}
