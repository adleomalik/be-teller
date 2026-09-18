package com.adleo.teller.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Table(name = "ROLE_MENU")
public class RoleMenu {

    @EmbeddedId
    private RoleMenuId id = new RoleMenuId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("menuId")
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    // Embedded ID Class untuk Composite Key
    @Data
    @Embeddable
    public static class RoleMenuId implements Serializable {
        @Column(name = "ROLE_ID")
        private Long roleId;

        @Column(name = "MENU_ID")
        private Long menuId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RoleMenuId that = (RoleMenuId) o;
            return Objects.equals(roleId, that.roleId) && Objects.equals(menuId, that.menuId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(roleId, menuId);
        }
    }
}