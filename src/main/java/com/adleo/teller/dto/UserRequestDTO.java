package com.adleo.teller.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private Long userId;
    private String username;
    private String password;
    private String nama;
    private String alamat;
    private String email;
    private Long telepon;
    private String programName;
}
