package com.ilyesHrissi.ProjetHotel.controllers;

import com.ilyesHrissi.ProjetHotel.models.User;
import com.ilyesHrissi.ProjetHotel.models.dto.CommonMessageResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {


        public ResponseEntity<CommonMessageResponseDTO> test(HttpServletRequest request) {
            User connectedUser= (User) request.getAttribute("user");
            System.out.println(connectedUser.getEmail());
            System.out.println(request.isUserInRole("USER"));
            return ResponseEntity.ok(CommonMessageResponseDTO.builder().message("Hello World").build());
        }
}
