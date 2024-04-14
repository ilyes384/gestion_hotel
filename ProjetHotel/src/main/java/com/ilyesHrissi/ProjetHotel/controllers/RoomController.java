package com.ilyesHrissi.ProjetHotel.controllers;

import com.ilyesHrissi.ProjetHotel.enums.ERoomType;
import com.ilyesHrissi.ProjetHotel.models.dto.CommonMessageResponseDTO;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.RoomDTO;
import com.ilyesHrissi.ProjetHotel.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private IRoomService roomService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CommonMessageResponseDTO> updateRoom(@PathVariable Long id,@RequestBody RoomDTO roomDTO) throws HttpException {
        roomService.updateRoom(id, roomDTO);
        return ResponseEntity.ok(CommonMessageResponseDTO.builder().message("Room updated successfully").build());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CommonMessageResponseDTO> createRoom(@RequestPart("room") RoomDTO roomDTO,@RequestPart("images") List<MultipartFile> images) throws HttpException {
        roomService.createRoom(roomDTO,images);
        return ResponseEntity.ok(CommonMessageResponseDTO.builder().message("Room added successfully").build());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonMessageResponseDTO> deleteRoom(@PathVariable Long id) throws HttpException {
        roomService.deleteRoom(id);
        return ResponseEntity.ok(CommonMessageResponseDTO.builder().message("Room deleted successfully").build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoom(@PathVariable Long id) throws HttpException {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }
    @GetMapping("/available")
    public ResponseEntity<List<RoomDTO>> findAvailableRooms(@RequestParam(required = false) LocalDate checkInDate, @RequestParam(required = false) LocalDate checkOutDate, @RequestParam(required = false) Double roomPrice, @RequestParam(required = false) ERoomType roomType) {
        return ResponseEntity.ok(roomService.findAvailableRooms(checkInDate, checkOutDate, roomPrice, roomType));
    }
}
