package com.adleo.teller.service;

import com.adleo.teller.dto.RoleRequestDTO;
import com.adleo.teller.dto.RoleResponseDTO;

import java.util.List;

public interface RoleService {
    List<RoleResponseDTO> getAllRoles();
    RoleResponseDTO getRoleById(Long id);
    RoleResponseDTO createRole(RoleRequestDTO requestDto, String currentUser);
    RoleResponseDTO updateRole(Long id, RoleRequestDTO requestDto, String currentUser);
    void deleteRole(Long id);
}
