package com.ilyesHrissi.ProjetHotel.mappers;

import com.ilyesHrissi.ProjetHotel.models.Reservation;
import com.ilyesHrissi.ProjetHotel.models.dto.ReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy= org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface ReservationMapper {
    void entityToDto(Reservation reservation, @MappingTarget ReservationDTO reservationDTO);
    void dtoToEntity(ReservationDTO reservationDTO, @MappingTarget Reservation reservation);
    Reservation dtoToEntity(ReservationDTO reservationDTO);
    ReservationDTO entityToDto(Reservation reservation);
    List<ReservationDTO> entitiesToDtos(List<Reservation> reservation);
}
