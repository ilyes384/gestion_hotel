package com.ilyesHrissi.ProjetHotel.controllers;

import com.ilyesHrissi.ProjetHotel.models.User;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.ReservationDTO;
import com.ilyesHrissi.ProjetHotel.services.IReservationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;

    @PreAuthorize("hasAuthority('ADMIN')")
   @GetMapping("/all")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
    List<ReservationDTO> reservations = reservationService.getAllReservations();
    return ResponseEntity.ok(reservations);
}
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) throws HttpException {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok("Reservation deleted successfully");
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) throws HttpException {
        reservationService.updateReservation(id, reservationDTO);
        return ResponseEntity.ok("Reservation updated successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id, HttpServletRequest request) throws HttpException {
        return ResponseEntity.ok(reservationService.getReservationById(id,request));
    }
    @PostMapping("/{id}")
    public ResponseEntity<ReservationDTO> createReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO,HttpServletRequest request) throws HttpException {
        return ResponseEntity.ok(reservationService.createReservation(id,reservationDTO,request));
    }
}