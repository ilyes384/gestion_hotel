package com.ilyesHrissi.ProjetHotel.models.dto;

import com.ilyesHrissi.ProjetHotel.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private String token;
    private ERole role;
}
