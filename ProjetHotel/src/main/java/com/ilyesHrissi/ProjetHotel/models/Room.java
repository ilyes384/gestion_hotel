package com.ilyesHrissi.ProjetHotel.models;

import com.ilyesHrissi.ProjetHotel.enums.ERoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer roomNumber;

    private double roomPrice;

    private int roomCapacity;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Image> roomImages;

    private ERoomType roomType;

    private String roomDescription;

    private Boolean isAvailable;


}
