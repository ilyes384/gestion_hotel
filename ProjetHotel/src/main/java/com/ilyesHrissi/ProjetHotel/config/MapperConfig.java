package com.ilyesHrissi.ProjetHotel.config;

import com.ilyesHrissi.ProjetHotel.mappers.ImageMapper;
import com.ilyesHrissi.ProjetHotel.mappers.ReservationMapper;
import com.ilyesHrissi.ProjetHotel.mappers.RoomMapper;
import com.ilyesHrissi.ProjetHotel.mappers.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }
    @Bean
    public RoomMapper roomMapper() {
        return Mappers.getMapper(RoomMapper.class);
    }
    @Bean
    public ImageMapper imageMapper() {
        return Mappers.getMapper(ImageMapper.class);

    }
    @Bean
    public ReservationMapper reservationMapper() {
        return Mappers.getMapper(ReservationMapper.class);
    }
}
