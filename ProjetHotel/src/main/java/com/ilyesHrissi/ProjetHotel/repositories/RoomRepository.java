package com.ilyesHrissi.ProjetHotel.repositories;

import com.ilyesHrissi.ProjetHotel.enums.ERoomType;
import com.ilyesHrissi.ProjetHotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE r.isAvailable = true AND (COALESCE(:price, r.roomPrice) >= r.roomPrice) AND (COALESCE(:type, r.roomType) = r.roomType) AND r.id NOT IN (SELECT res.room.id FROM Reservation res WHERE ((COALESCE(:checkIn, res.checkOutDate) BETWEEN res.checkInDate AND res.checkOutDate) OR (COALESCE(:checkOut, res.checkInDate) BETWEEN res.checkInDate AND res.checkOutDate)))")
List<Room> findAvailableRooms(
        @Param("checkIn") LocalDate checkInDate,
        @Param("checkOut") LocalDate checkOutDate,
        @Param("price") Double roomPrice,
        @Param("type") ERoomType roomType);
}
