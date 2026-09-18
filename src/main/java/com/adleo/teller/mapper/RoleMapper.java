package com.adleo.teller.mapper;

import com.adleo.teller.dto.RoleRequestDTO;
import com.adleo.teller.dto.RoleResponseDTO;
import com.adleo.teller.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    // Konversi dari Entity ke Response DTO
    public RoleResponseDTO toResponseDto(Role role) {
        if (role == null) {
            return null;
        }

        RoleResponseDTO dto = new RoleResponseDTO();
        dto.setRoleId(role.getRoleId());
        dto.setNama(role.getNama());
        dto.setProgramName(role.getProgramName());
        dto.setCreatedDate(role.getCreatedDate());
        dto.setCreatedBy(role.getCreatedBy());
        dto.setUpdatedDate(role.getUpdatedDate());
        dto.setUpdatedBy(role.getUpdatedBy());
        return dto;
    }

    // Konversi dari Request DTO ke Entity (untuk Create/Insert)
    public Role toEntity(RoleRequestDTO requestDto) {
        if (requestDto == null) {
            return null;
        }

        Role role = new Role();
        role.setNama(requestDto.getNama());
        role.setProgramName(requestDto.getProgramName());
        return role;
    }

    // Melakukan update pada Entity yang sudah ada menggunakan data dari Request DTO
    public void updateEntityFromDto(RoleRequestDTO requestDto, Role role) {
        if (requestDto == null || role == null) {
            return;
        }

        role.setNama(requestDto.getNama());
        role.setProgramName(requestDto.getProgramName());
    }
}