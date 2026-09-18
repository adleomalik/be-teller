package com.adleo.teller.service;

import com.adleo.teller.dto.MenuResponseDTO;
import com.adleo.teller.dto.RoleMenuRequestDTO;

import java.util.List;

public interface RoleMenuService {
    List<MenuResponseDTO> getMenusByRoleId(Long roleId);
    void assignMenusToRole(RoleMenuRequestDTO requestDto, String currentUser);
}
