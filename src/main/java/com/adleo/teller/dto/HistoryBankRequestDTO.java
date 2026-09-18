package com.adleo.teller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryBankRequestDTO {
    private String idHistoryBank;
    private LocalDateTime tanggal;
    private Long noRek;
    private Integer statusKet;
    private String nama;
    private Long uang;
    private Long norekDituju;
    private Long noTlp;
}
