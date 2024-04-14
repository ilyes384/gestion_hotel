package com.ilyesHrissi.ProjetHotel.services.impls;

import com.ilyesHrissi.ProjetHotel.enums.ERoomType;
import com.ilyesHrissi.ProjetHotel.mappers.RoomMapper;
import com.ilyesHrissi.ProjetHotel.models.Image;
import com.ilyesHrissi.ProjetHotel.models.Room;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.RoomDTO;
import com.ilyesHrissi.ProjetHotel.repositories.ImageRepository;
import com.ilyesHrissi.ProjetHotel.repositories.RoomRepository;
import com.ilyesHrissi.ProjetHotel.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public RoomDTO getRoomById(Long id) throws HttpException {
        Room room = roomRepository.findById(id).orElseThrow(() -> new HttpException("Room not found", HttpStatus.NOT_FOUND));
        return roomMapper.entityToDto(room);
    }

    @Override
    public RoomDTO createRoom(RoomDTO room, List<MultipartFile> images) throws HttpException {
        Room roomEntity = roomMapper.dtoToEntity(room);
        if (images != null){
            List<Image> imagesList = new ArrayList<>();
            for (MultipartFile image : images) {
                try {
                   Image img = imageRepository.save(Image.builder().name(image.getOriginalFilename()).picByte(image.getBytes()).build());
                     imagesList.add(img);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            roomEntity.setRoomImages(imagesList);
        }
        return roomMapper.entityToDto(roomRepository.save(roomEntity));
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return roomMapper.entitiesToDtos(roomRepository.findAll());
    }



    @Override
    public void updateRoom(Long id, RoomDTO roomDTO) throws HttpException {
        Room room = roomRepository.findById(id).orElseThrow(() -> new HttpException("Room not found", HttpStatus.NOT_FOUND));
        roomMapper.dtoToEntity(roomDTO, room);
        roomRepository.save(room);
    }
    @Override
    public void deleteRoom(Long id) throws HttpException {
        Room room = roomRepository.findById(id).orElseThrow(() -> new HttpException("Room not found", HttpStatus.NOT_FOUND));
        roomRepository.delete(room);
    }

    @Override
    public List<RoomDTO> findAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, Double roomPrice, ERoomType roomType) {
        List<Room> rooms = roomRepository.findAvailableRooms(checkInDate, checkOutDate, roomPrice, roomType);
        return rooms.stream().map(roomMapper::entityToDto).collect(Collectors.toList());
    }
}
