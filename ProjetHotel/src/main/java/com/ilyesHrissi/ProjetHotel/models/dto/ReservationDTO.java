package com.ilyesHrissi.ProjetHotel.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilyesHrissi.ProjetHotel.enums.EReservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private LocalDate reservationDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private EReservation reservationStatus;

    private RoomDTO room;

}
