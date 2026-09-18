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
@Table(name = "sub_menu")
public class SubMenu {

    @Id
    @Column(name = "sub_menu_id", precision = 11, scale = 0, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subMenuId;

    @Column(name = "nama", length = 225)
    private String nama;

    @Column(name = "icon", length = 50)
    private String icon;

    @Column(name = "url", length = 100)
    private String url;

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

    @Column(name = "menu_id", precision = 11, scale = 0)
    private Long menuId;
}