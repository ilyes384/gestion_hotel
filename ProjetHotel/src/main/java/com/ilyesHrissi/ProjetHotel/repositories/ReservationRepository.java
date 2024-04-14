package com.ilyesHrissi.ProjetHotel.repositories;

import com.ilyesHrissi.ProjetHotel.models.Reservation;
import com.ilyesHrissi.ProjetHotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    boolean existsByRoomAndCheckInDateBetween(Room room, LocalDate checkInDate, LocalDate checkOutDate);

    boolean existsByRoomAndCheckOutDateBetween(Room room, LocalDate checkInDate, LocalDate checkOutDate);

    boolean existsByRoomAndCheckInDateBeforeAndCheckOutDateAfter(Room room, LocalDate checkInDate, LocalDate checkOutDate);

}
