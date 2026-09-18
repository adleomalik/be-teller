package com.adleo.teller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "master_bank")
public class MasterBank {

    @Id
    @Column(name = "norek", precision = 7, scale = 0, nullable = false)
    private Long norek;

    @Column(name = "nama", length = 30)
    private String nama;

    @Column(name = "alamat", length = 50)
    private String alamat;

    @Column(name = "notlp", precision = 20, scale = 0)
    private Long notlp;

    @Column(name = "saldo", precision = 20, scale = 0)
    private Long saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;
}