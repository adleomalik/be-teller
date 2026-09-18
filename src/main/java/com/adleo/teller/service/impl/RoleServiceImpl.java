package com.adleo.teller.service.impl;

import com.adleo.teller.dto.RoleRequestDTO;
import com.adleo.teller.dto.RoleResponseDTO;
import com.adleo.teller.entity.Role;
import com.adleo.teller.mapper.RoleMapper;
import com.adleo.teller.repository.RoleRepository;
import com.adleo.teller.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper; //

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toResponseDto) // <--- Menggunakan mapper
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role tidak ditemukan dengan ID: " + id));
        return roleMapper.toResponseDto(role);
    }

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO requestDto, String currentUser) {
        Role role = roleMapper.toEntity(requestDto);
        role.setCreatedDate(LocalDate.now()); // <--- Menggunakan LocalDate.now()
        role.setCreatedBy(currentUser != null ? currentUser : "System");

        Role savedRole = roleRepository.save(role);
        return roleMapper.toResponseDto(savedRole);
    }

    @Override
    public RoleResponseDTO updateRole(Long id, RoleRequestDTO requestDto, String currentUser) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role tidak ditemukan dengan ID: " + id));

        roleMapper.updateEntityFromDto(requestDto, role);
        role.setUpdatedDate(LocalDate.now()); // <--- Menggunakan LocalDate.now()
        role.setUpdatedBy(currentUser != null ? currentUser : "System");

        Role updatedRole = roleRepository.save(role);
        return roleMapper.toResponseDto(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role tidak ditemukan dengan ID: " + id);
        }
        roleRepository.deleteById(id);
    }
}
