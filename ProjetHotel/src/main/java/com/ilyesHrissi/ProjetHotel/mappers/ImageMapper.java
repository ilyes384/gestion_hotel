package com.ilyesHrissi.ProjetHotel.mappers;

import com.ilyesHrissi.ProjetHotel.models.Image;
import com.ilyesHrissi.ProjetHotel.models.dto.ImageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy= org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface ImageMapper {
    void entityToDto(Image image, @MappingTarget ImageDTO imageDTO);
    void dtoToEntity(ImageDTO imageDTO, @MappingTarget Image image);
    Image dtoToEntity(ImageDTO imageDTO);
    ImageDTO entityToDto(Image image);

}


