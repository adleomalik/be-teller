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
@Table(name = "hak_akses")
public class HakAkses {

    @Id
    @Column(name = "hak_akses_id", precision = 11, scale = 0, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hakAksesId;

    @Column(name = "program_name", length = 100)
    private String programName;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "updated_by", length = 200)
    private String updatedBy;

    @Column(name = "user_id", precision = 11, scale = 0)
    private Long userId;

    @Column(name = "role_id", precision = 11, scale = 0)
    private Long roleId;
}