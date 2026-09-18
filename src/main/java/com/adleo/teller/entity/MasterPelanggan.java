package com.adleo.teller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "master_pelanggan")
public class MasterPelanggan {

    @Id
    @Column(name = "id_pelanggan", precision = 9, scale = 0, nullable = false)
    private Long idPelanggan;

    @Column(name = "nama", length = 50)
    private String nama;

    @Column(name = "no_telp", precision = 38, scale = 0)
    private Long noTelp;

    @Column(name = "alamat", length = 100)
    private String alamat;

    @Column(name = "user_id", precision = 11, scale = 0)
    private Long userId;
}