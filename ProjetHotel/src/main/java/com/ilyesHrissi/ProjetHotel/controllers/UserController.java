package com.ilyesHrissi.ProjetHotel.controllers;

import com.ilyesHrissi.ProjetHotel.models.dto.CommonMessageResponseDTO;
import com.ilyesHrissi.ProjetHotel.models.dto.HttpException;
import com.ilyesHrissi.ProjetHotel.models.dto.UserDTO;
import com.ilyesHrissi.ProjetHotel.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CommonMessageResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws HttpException {
        userService.updateUser(id, userDTO);
        return ResponseEntity.ok(CommonMessageResponseDTO.builder().message("User updated successfully").build());
    }
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonMessageResponseDTO> deleteUser(@PathVariable Long id) throws HttpException {
        userService.deleteUser(id);
        return ResponseEntity.ok(CommonMessageResponseDTO.builder().message("User deleted successfully").build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) throws HttpException {
        return ResponseEntity.ok(userService.getUser(id));
    }
    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/self")
    public ResponseEntity<CommonMessageResponseDTO> updateSelf(@RequestBody UserDTO userDTO, HttpServletRequest request) throws HttpException {
        userService.updateSelf(userDTO,request);
        return ResponseEntity.ok(CommonMessageResponseDTO.builder().message("User updated successfully").build());
    }
}
