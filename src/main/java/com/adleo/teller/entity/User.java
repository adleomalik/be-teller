package com.adleo.teller.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name="username", nullable = false, length = 225)
    private String username;

    @Column(name="password", nullable = false, length = 100)
    private String password;

    @Column(name="nama", nullable = false, length = 100)
    private String nama;

    @Column(name="alamat", length = 100)
    private String alamat;

    @Column(name="email", nullable = false, length = 25)
    private String email;

    @Column(name = "telepon", precision = 20, scale = 0)
    private Long telepon;

    @Column(name="program_name", nullable = false, length = 100)
    private String programName;

    @Column(name="created_date")
    private LocalDateTime createdDate;

    @Column(name="created_by", length = 100)
    private String createdBy;

    @Column(name="updated_date")
    private LocalDateTime updatedDate;

    @Column(name="updated_by", length = 100)
    private String updatedBy;

}
