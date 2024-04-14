package com.ilyesHrissi.ProjetHotel.models.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HttpException extends Exception  {
    private String message;
    private HttpStatus status;
}
