package com.ilyesHrissi.ProjetHotel.services.impls;

import com.ilyesHrissi.ProjetHotel.enums.ERole;
import com.ilyesHrissi.ProjetHotel.mappers.ReservationMapper;
import com.ilyesHrissi.ProjetHotel.models.Reservation;
import com.ilyesHrissi.ProjetHotel.models.Room;
import com.ilyesHrissi.ProjetHotel.models.User;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.ReservationDTO;
import com.ilyesHrissi.ProjetHotel.repositories.ReservationRepository;
import com.ilyesHrissi.ProjetHotel.repositories.RoomRepository;
import com.ilyesHrissi.ProjetHotel.services.IReservationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public ReservationDTO createReservation(Long id ,ReservationDTO reservationDTO,HttpServletRequest request) throws HttpException{
        Room room = roomRepository.findById(id).orElseThrow(() -> new HttpException("Room not found", HttpStatus.NOT_FOUND));
        if(reservationDTO.getCheckInDate().isAfter(reservationDTO.getCheckOutDate())){
            throw new HttpException("Check in date must be before check out date", HttpStatus.BAD_REQUEST);
        }
        if (reservationRepository.existsByRoomAndCheckInDateBetween(room, reservationDTO.getCheckInDate(), reservationDTO.getCheckOutDate()) ||
                reservationRepository.existsByRoomAndCheckOutDateBetween(room, reservationDTO.getCheckInDate(), reservationDTO.getCheckOutDate()) ||
                reservationRepository.existsByRoomAndCheckInDateBeforeAndCheckOutDateAfter(room, reservationDTO.getCheckInDate(), reservationDTO.getCheckOutDate())) {
            throw new HttpException("Room is already reserved", HttpStatus.BAD_REQUEST);
        }
        Reservation reservationEntity = reservationMapper.dtoToEntity(reservationDTO);
        reservationEntity.setRoom(room);
        User user = (User)request.getAttribute("user");
        reservationEntity.setUser(user);
        return reservationMapper.entityToDto(reservationRepository.save(reservationEntity));

    }


    @Override
    public void deleteReservation(Long id) throws HttpException {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new HttpException("Reservation not found", HttpStatus.NOT_FOUND));
        reservationRepository.delete(reservation);
    }

    @Override
    public void updateReservation(Long id, ReservationDTO reservationDTO) throws HttpException {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new HttpException("Reservation not found", HttpStatus.NOT_FOUND));
        reservationMapper.dtoToEntity(reservationDTO, reservation);
        reservationRepository.save(reservation);

    }

    @Override
    public ReservationDTO getReservationById(Long id, HttpServletRequest request) throws HttpException {
    Reservation res = reservationRepository.findById(id).orElseThrow(() -> new HttpException("Reservation not found", HttpStatus.NOT_FOUND));
    User user = (User)request.getAttribute("user");
    if( user.getRole().equals(ERole.ADMIN) || res.getUser().getId().equals(user.getId())){
        return reservationMapper.entityToDto(res);
    }
    throw new HttpException("Forbidden", HttpStatus.FORBIDDEN);
    }
    @Override
    public List<ReservationDTO> getAllReservations() {
        return reservationMapper.entitiesToDtos(reservationRepository.findAll());
    }

}
