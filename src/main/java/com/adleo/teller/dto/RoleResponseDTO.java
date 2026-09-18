package com.adleo.teller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RoleResponseDTO {
    private Long roleId;
    private String nama;
    private String programName;
    private LocalDate createdDate;
    private String createdBy;
    private LocalDate updatedDate;
    private String updatedBy;
}
