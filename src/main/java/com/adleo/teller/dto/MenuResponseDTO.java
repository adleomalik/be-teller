package com.adleo.teller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MenuResponseDTO {
    private Long menuId;
    private String nama;
    private String icon;
    private String url;
    private String programName;
    private LocalDate createdDate;
    private String createdBy;
    private LocalDate updatedDate;
    private String updatedBy;
}
