package com.adleo.teller.repository;

import com.adleo.teller.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleMenuRepository extends JpaRepository<RoleMenu, RoleMenu.RoleMenuId> {
    List<RoleMenu> findByIdRoleId(Long roleId);
    void deleteByIdRoleId(Long roleId);
}
