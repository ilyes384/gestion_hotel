package com.ilyesHrissi.ProjetHotel.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilyesHrissi.ProjetHotel.enums.ERoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Integer roomNumber;

    private double roomPrice;

    private int roomCapacity;

    private List<ImageDTO> roomImages;

    private ERoomType roomType;

    private String roomDescription;

    private Boolean isAvailable;

}
