package com.ilyesHrissi.ProjetHotel.mappers;

import com.ilyesHrissi.ProjetHotel.models.Image;
import com.ilyesHrissi.ProjetHotel.models.Room;
import com.ilyesHrissi.ProjetHotel.models.dto.ImageDTO;
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
public class RoomMapperImpl implements RoomMapper {

    @Override
    public void entityToDto(Room room, RoomDTO roomDTO) {
        if ( room == null ) {
            return;
        }

        if ( room.getId() != null ) {
            roomDTO.setId( room.getId() );
        }
        if ( room.getRoomNumber() != null ) {
            roomDTO.setRoomNumber( room.getRoomNumber() );
        }
        roomDTO.setRoomPrice( room.getRoomPrice() );
        roomDTO.setRoomCapacity( room.getRoomCapacity() );
        if ( roomDTO.getRoomImages() != null ) {
            List<ImageDTO> list = imageListToImageDTOList( room.getRoomImages() );
            if ( list != null ) {
                roomDTO.getRoomImages().clear();
                roomDTO.getRoomImages().addAll( list );
            }
        }
        else {
            List<ImageDTO> list = imageListToImageDTOList( room.getRoomImages() );
            if ( list != null ) {
                roomDTO.setRoomImages( list );
            }
        }
        if ( room.getRoomType() != null ) {
            roomDTO.setRoomType( room.getRoomType() );
        }
        if ( room.getRoomDescription() != null ) {
            roomDTO.setRoomDescription( room.getRoomDescription() );
        }
        if ( room.getIsAvailable() != null ) {
            roomDTO.setIsAvailable( room.getIsAvailable() );
        }
    }

    @Override
    public void dtoToEntity(RoomDTO roomDTO, Room room) {
        if ( roomDTO == null ) {
            return;
        }

        if ( roomDTO.getId() != null ) {
            room.setId( roomDTO.getId() );
        }
        if ( roomDTO.getRoomNumber() != null ) {
            room.setRoomNumber( roomDTO.getRoomNumber() );
        }
        room.setRoomPrice( roomDTO.getRoomPrice() );
        room.setRoomCapacity( roomDTO.getRoomCapacity() );
        if ( room.getRoomImages() != null ) {
            List<Image> list = imageDTOListToImageList( roomDTO.getRoomImages() );
            if ( list != null ) {
                room.getRoomImages().clear();
                room.getRoomImages().addAll( list );
            }
        }
        else {
            List<Image> list = imageDTOListToImageList( roomDTO.getRoomImages() );
            if ( list != null ) {
                room.setRoomImages( list );
            }
        }
        if ( roomDTO.getRoomType() != null ) {
            room.setRoomType( roomDTO.getRoomType() );
        }
        if ( roomDTO.getRoomDescription() != null ) {
            room.setRoomDescription( roomDTO.getRoomDescription() );
        }
        if ( roomDTO.getIsAvailable() != null ) {
            room.setIsAvailable( roomDTO.getIsAvailable() );
        }
    }

    @Override
    public Room dtoToEntity(RoomDTO roomDTO) {
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

    @Override
    public RoomDTO entityToDto(Room room) {
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

    @Override
    public List<RoomDTO> entitiesToDtos(List<Room> rooms) {
        if ( rooms == null ) {
            return null;
        }

        List<RoomDTO> list = new ArrayList<RoomDTO>( rooms.size() );
        for ( Room room : rooms ) {
            list.add( entityToDto( room ) );
        }

        return list;
    }

    @Override
    public List<Room> dtosToEntities(List<RoomDTO> roomDTOS) {
        if ( roomDTOS == null ) {
            return null;
        }

        List<Room> list = new ArrayList<Room>( roomDTOS.size() );
        for ( RoomDTO roomDTO : roomDTOS ) {
            list.add( dtoToEntity( roomDTO ) );
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
}
