package com.ilyesHrissi.ProjetHotel.services;

import com.ilyesHrissi.ProjetHotel.models.Reservation;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.ReservationDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface IReservationService {
    public ReservationDTO createReservation(Long id,ReservationDTO reservationDTO,HttpServletRequest request) throws HttpException;
    void deleteReservation(Long id) throws HttpException;
    void updateReservation(Long id, ReservationDTO reservationDTO) throws HttpException;
    public ReservationDTO getReservationById(Long id, HttpServletRequest request) throws HttpException;
    public List<ReservationDTO> getAllReservations();

}
