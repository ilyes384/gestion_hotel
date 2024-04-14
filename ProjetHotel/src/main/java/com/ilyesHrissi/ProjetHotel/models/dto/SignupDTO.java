package com.ilyesHrissi.ProjetHotel.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
