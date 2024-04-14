package com.ilyesHrissi.ProjetHotel.mappers;

import com.ilyesHrissi.ProjetHotel.models.Image;
import com.ilyesHrissi.ProjetHotel.models.Reservation;
import com.ilyesHrissi.ProjetHotel.models.Room;
import com.ilyesHrissi.ProjetHotel.models.dto.ImageDTO;
import com.ilyesHrissi.ProjetHotel.models.dto.ReservationDTO;
import com.ilyesHrissi.ProjetHotel.models.dto.RoomDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-14T00:23:26+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public void entityToDto(Reservation reservation, ReservationDTO reservationDTO) {
        if ( reservation == null ) {
            return;
        }

        if ( reservation.getId() != null ) {
            reservationDTO.setId( reservation.getId() );
        }
        if ( reservation.getReservationDate() != null ) {
            reservationDTO.setReservationDate( reservation.getReservationDate() );
        }
        if ( reservation.getCheckInDate() != null ) {
            reservationDTO.setCheckInDate( reservation.getCheckInDate() );
        }
        if ( reservation.getCheckOutDate() != null ) {
            reservationDTO.setCheckOutDate( reservation.getCheckOutDate() );
        }
        if ( reservation.getReservationStatus() != null ) {
            reservationDTO.setReservationStatus( reservation.getReservationStatus() );
        }
        if ( reservation.getRoom() != null ) {
            if ( reservationDTO.getRoom() == null ) {
                reservationDTO.setRoom( RoomDTO.builder().build() );
            }
            roomToRoomDTO( reservation.getRoom(), reservationDTO.getRoom() );
        }
    }

    @Override
    public void dtoToEntity(ReservationDTO reservationDTO, Reservation reservation) {
        if ( reservationDTO == null ) {
            return;
        }

        if ( reservationDTO.getId() != null ) {
            reservation.setId( reservationDTO.getId() );
        }
        if ( reservationDTO.getReservationDate() != null ) {
            reservation.setReservationDate( reservationDTO.getReservationDate() );
        }
        if ( reservationDTO.getCheckInDate() != null ) {
            reservation.setCheckInDate( reservationDTO.getCheckInDate() );
        }
        if ( reservationDTO.getCheckOutDate() != null ) {
            reservation.setCheckOutDate( reservationDTO.getCheckOutDate() );
        }
        if ( reservationDTO.getReservationStatus() != null ) {
            reservation.setReservationStatus( reservationDTO.getReservationStatus() );
        }
        if ( reservationDTO.getRoom() != null ) {
            if ( reservation.getRoom() == null ) {
                reservation.setRoom( Room.builder().build() );
            }
            roomDTOToRoom( reservationDTO.getRoom(), reservation.getRoom() );
        }
    }

    @Override
    public Reservation dtoToEntity(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.id( reservationDTO.getId() );
        reservation.reservationDate( reservationDTO.getReservationDate() );
        reservation.checkInDate( reservationDTO.getCheckInDate() );
        reservation.checkOutDate( reservationDTO.getCheckOutDate() );
        reservation.reservationStatus( reservationDTO.getReservationStatus() );
        reservation.room( roomDTOToRoom1( reservationDTO.getRoom() ) );

        return reservation.build();
    }

    @Override
    public ReservationDTO entityToDto(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTO.ReservationDTOBuilder reservationDTO = ReservationDTO.builder();

        reservationDTO.id( reservation.getId() );
        reservationDTO.reservationDate( reservation.getReservationDate() );
        reservationDTO.checkInDate( reservation.getCheckInDate() );
        reservationDTO.checkOutDate( reservation.getCheckOutDate() );
        reservationDTO.reservationStatus( reservation.getReservationStatus() );
        reservationDTO.room( roomToRoomDTO1( reservation.getRoom() ) );

        return reservationDTO.build();
    }

    @Override
    public List<ReservationDTO> entitiesToDtos(List<Reservation> reservation) {
        if ( reservation == null ) {
            return null;
        }

        List<ReservationDTO> list = new ArrayList<ReservationDTO>( reservation.size() );
        for ( Reservation reservation1 : reservation ) {
            list.add( entityToDto( reservation1 ) );
        }

        return list;
    }

    protected ImageDTO imageToImageDTO(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDTO.ImageDTOBuilder imageDTO = ImageDTO.builder();

        imageDTO.id( image.getId() );
        imageDTO.name( image.getName() );
        byte[] picByte = image.getPicByte();
        if ( picByte != null ) {
            imageDTO.picByte( Arrays.copyOf( picByte, picByte.length ) );
        }

        return imageDTO.build();
    }

    protected List<ImageDTO> imageListToImageDTOList(List<Image> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageDTO> list1 = new ArrayList<ImageDTO>( list.size() );
        for ( Image image : list ) {
            list1.add( imageToImageDTO( image ) );
        }

        return list1;
    }

    protected void roomToRoomDTO(Room room, RoomDTO mappingTarget) {
        if ( room == null ) {
            return;
        }

        if ( room.getId() != null ) {
            mappingTarget.setId( room.getId() );
        }
        if ( room.getRoomNumber() != null ) {
            mappingTarget.setRoomNumber( room.getRoomNumber() );
        }
        mappingTarget.setRoomPrice( room.getRoomPrice() );
        mappingTarget.setRoomCapacity( room.getRoomCapacity() );
        if ( mappingTarget.getRoomImages() != null ) {
            List<ImageDTO> list = imageListToImageDTOList( room.getRoomImages() );
            if ( list != null ) {
                mappingTarget.getRoomImages().clear();
                mappingTarget.getRoomImages().addAll( list );
            }
        }
        else {
            List<ImageDTO> list = imageListToImageDTOList( room.getRoomImages() );
            if ( list != null ) {
                mappingTarget.setRoomImages( list );
            }
        }
        if ( room.getRoomType() != null ) {
            mappingTarget.setRoomType( room.getRoomType() );
        }
        if ( room.getRoomDescription() != null ) {
            mappingTarget.setRoomDescription( room.getRoomDescription() );
        }
        if ( room.getIsAvailable() != null ) {
            mappingTarget.setIsAvailable( room.getIsAvailable() );
        }
    }

    protected Image imageDTOToImage(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        image.id( imageDTO.getId() );
        image.name( imageDTO.getName() );
        byte[] picByte = imageDTO.getPicByte();
        if ( picByte != null ) {
            image.picByte( Arrays.copyOf( picByte, picByte.length ) );
        }

        return image.build();
    }

    protected List<Image> imageDTOListToImageList(List<ImageDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Image> list1 = new ArrayList<Image>( list.size() );
        for ( ImageDTO imageDTO : list ) {
            list1.add( imageDTOToImage( imageDTO ) );
        }

        return list1;
    }

    protected void roomDTOToRoom(RoomDTO roomDTO, Room mappingTarget) {
        if ( roomDTO == null ) {
            return;
        }

        if ( roomDTO.getId() != null ) {
            mappingTarget.setId( roomDTO.getId() );
        }
        if ( roomDTO.getRoomNumber() != null ) {
            mappingTarget.setRoomNumber( roomDTO.getRoomNumber() );
        }
        mappingTarget.setRoomPrice( roomDTO.getRoomPrice() );
        mappingTarget.setRoomCapacity( roomDTO.getRoomCapacity() );
        if ( mappingTarget.getRoomImages() != null ) {
            List<Image> list = imageDTOListToImageList( roomDTO.getRoomImages() );
            if ( list != null ) {
                mappingTarget.getRoomImages().clear();
                mappingTarget.getRoomImages().addAll( list );
            }
        }
        else {
            List<Image> list = imageDTOListToImageList( roomDTO.getRoomImages() );
            if ( list != null ) {
                mappingTarget.setRoomImages( list );
            }
        }
        if ( roomDTO.getRoomType() != null ) {
            mappingTarget.setRoomType( roomDTO.getRoomType() );
        }
        if ( roomDTO.getRoomDescription() != null ) {
            mappingTarget.setRoomDescription( roomDTO.getRoomDescription() );
        }
        if ( roomDTO.getIsAvailable() != null ) {
            mappingTarget.setIsAvailable( roomDTO.getIsAvailable() );
        }
    }

    protected Room roomDTOToRoom1(RoomDTO roomDTO) {
        if ( roomDTO == null ) {
            return null;
        }

        Room.RoomBuilder room = Room.builder();

        room.id( roomDTO.getId() );
        room.roomNumber( roomDTO.getRoomNumber() );
        room.roomPrice( roomDTO.getRoomPrice() );
        room.roomCapacity( roomDTO.getRoomCapacity() );
        room.roomImages( imageDTOListToImageList( roomDTO.getRoomImages() ) );
        room.roomType( roomDTO.getRoomType() );
        room.roomDescription( roomDTO.getRoomDescription() );
        room.isAvailable( roomDTO.getIsAvailable() );

        return room.build();
    }

    protected RoomDTO roomToRoomDTO1(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDTO.RoomDTOBuilder roomDTO = RoomDTO.builder();

        roomDTO.id( room.getId() );
        roomDTO.roomNumber( room.getRoomNumber() );
        roomDTO.roomPrice( room.getRoomPrice() );
        roomDTO.roomCapacity( room.getRoomCapacity() );
        roomDTO.roomImages( imageListToImageDTOList( room.getRoomImages() ) );
        roomDTO.roomType( room.getRoomType() );
        roomDTO.roomDescription( room.getRoomDescription() );
        roomDTO.isAvailable( room.getIsAvailable() );

        return roomDTO.build();
    }
}
