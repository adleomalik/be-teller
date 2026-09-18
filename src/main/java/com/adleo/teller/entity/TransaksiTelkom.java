package com.adleo.teller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaksi_telkom")
public class TransaksiTelkom {

    @Id
    @Column(name = "id_transaksi", precision = 4, scale = 0, nullable = false)
    private Long idTransaksi;

    @Column(name = "bulan_tagihan", precision = 2, scale = 0)
    private Integer bulanTagihan;

    @Column(name = "tahun_tagihan", precision = 4, scale = 0)
    private Integer tahunTagihan;

    @Column(name = "uang", precision = 8, scale = 0)
    private Long uang;

    @Column(name = "status", precision = 1, scale = 0)
    private Integer status;

    @Column(name = "id_pelanggan", precision = 9, scale = 0)
    private Long idPelanggan;
}