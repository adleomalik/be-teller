package com.adleo.teller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaksi_nasabah")
public class TransaksiNasabah {

    @Id
    @Column(name = "id_transaksi_nasabah", precision = 10, scale = 0, nullable = false)
    private Long idTransaksiNasabah;

    @Column(name = "norek", precision = 7, scale = 0)
    private Long norek;

    @Column(name = "tanggal", nullable = false)
    private LocalDate tanggal;

    @Column(name = "status", length = 1, nullable = false)
    private Character status;

    @Column(name = "uang", precision = 20, scale = 0, nullable = false)
    private Long uang;

    @Column(name = "status_ket", precision = 1, scale = 0)
    private Integer statusKet;

    @Column(name = "norek_dituju", precision = 7, scale = 0)
    private Long norekDituju;

    @Column(name = "no_tlp", precision = 20, scale = 0)
    private Long noTlp;

    @Column(name = "user_id", precision = 11, scale = 0)
    private Long userId;
}