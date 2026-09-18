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
@Table(name = "history_telkom")
public class HistoryTelkom {

    @Id
    @Column(name = "id_history", precision = 4, scale = 0, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistory;

    @Column(name = "tanggal_bayar")
    private LocalDate tanggalBayar;

    @Column(name = "bulan_tagihan", precision = 2, scale = 0)
    private Integer bulanTagihan;

    @Column(name = "tahun_tagihan", precision = 9, scale = 0)
    private Long tahunTagihan;

    @Column(name = "uang", precision = 8, scale = 0)
    private Long uang;

    @Column(name = "id_pelanggan", precision = 9, scale = 0)
    private Long idPelanggan;
}