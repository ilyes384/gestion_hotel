package com.ilyesHrissi.ProjetHotel.services;

import com.ilyesHrissi.ProjetHotel.enums.ERoomType;
import com.ilyesHrissi.ProjetHotel.models.Room;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.RoomDTO;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface IRoomService  {
    public RoomDTO getRoomById(Long id) throws HttpException;
    public RoomDTO createRoom(RoomDTO room, List<MultipartFile> images) throws HttpException;

    public void deleteRoom(Long id) throws HttpException;

    public void updateRoom(Long id, RoomDTO roomDTO) throws HttpException;

    public List<RoomDTO> getAllRooms() ;
    public List<RoomDTO> findAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, Double roomPrice, ERoomType roomType);
}
