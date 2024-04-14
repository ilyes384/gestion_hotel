package com.ilyesHrissi.ProjetHotel.mappers;

import com.ilyesHrissi.ProjetHotel.models.Image;
import com.ilyesHrissi.ProjetHotel.models.dto.ImageDTO;
import java.util.Arrays;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-14T00:23:26+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ImageMapperImpl implements ImageMapper {

    @Override
    public void entityToDto(Image image, ImageDTO imageDTO) {
        if ( image == null ) {
            return;
        }

        if ( image.getId() != null ) {
            imageDTO.setId( image.getId() );
        }
        if ( image.getName() != null ) {
            imageDTO.setName( image.getName() );
        }
        byte[] picByte = image.getPicByte();
        if ( picByte != null ) {
            imageDTO.setPicByte( Arrays.copyOf( picByte, picByte.length ) );
        }
    }

    @Override
    public void dtoToEntity(ImageDTO imageDTO, Image image) {
        if ( imageDTO == null ) {
            return;
        }

        if ( imageDTO.getId() != null ) {
            image.setId( imageDTO.getId() );
        }
        if ( imageDTO.getName() != null ) {
            image.setName( imageDTO.getName() );
        }
        byte[] picByte = imageDTO.getPicByte();
        if ( picByte != null ) {
            image.setPicByte( Arrays.copyOf( picByte, picByte.length ) );
        }
    }

    @Override
    public Image dtoToEntity(ImageDTO imageDTO) {
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

    @Override
    public ImageDTO entityToDto(Image image) {
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
}
