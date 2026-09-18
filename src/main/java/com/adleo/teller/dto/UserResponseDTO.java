package com.adleo.teller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private Long userId;
    private String username;
    private String nama;
    private String alamat;
    private String email;
    private Long telepon;
    private String programName;
    private LocalDateTime createdDate;
}
