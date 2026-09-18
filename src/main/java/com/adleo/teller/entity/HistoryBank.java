package com.adleo.teller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history_bank")
public class HistoryBank {

    @Id
    @Column(name = "id_history_bank", precision = 10, scale = 0, nullable = false)
    private String idHistoryBank;

    @Column(name = "tanggal")
    private LocalDateTime tanggal;

    @Column(name = "norek", precision = 7, scale = 0)
    private Long norek;

    @Column(name = "status_ket", precision = 1, scale = 0)
    private Integer statusKet;

    @Column(name = "nama", length = 20)
    private String nama;

    @Column(name = "uang", precision = 20, scale = 0)
    private Long uang;

    @Column(name = "norek_dituju", precision = 7, scale = 0)
    private Long norekDituju;

    @Column(name = "no_tlp", precision = 20, scale = 0)
    private Long noTlp;
}