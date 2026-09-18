package com.adleo.teller.service.impl;

import com.adleo.teller.dto.MenuResponseDTO;
import com.adleo.teller.dto.RoleMenuRequestDTO;
import com.adleo.teller.dto.RoleRequestDTO;
import com.adleo.teller.dto.RoleResponseDTO;
import com.adleo.teller.entity.Menu;
import com.adleo.teller.entity.Role;
import com.adleo.teller.entity.RoleMenu;
import com.adleo.teller.mapper.MenuMapper;
import com.adleo.teller.repository.MenuRepository;
import com.adleo.teller.repository.RoleMenuRepository;
import com.adleo.teller.repository.RoleRepository;
import com.adleo.teller.service.RoleMenuService;
import com.adleo.teller.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuRepository roleMenuRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuResponseDTO> getMenusByRoleId(Long roleId) {
        List<RoleMenu> roleMenus = roleMenuRepository.findByIdRoleId(roleId);
        return roleMenus.stream()
                .map(rm -> menuMapper.toResponseDTO(rm.getMenu()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void assignMenusToRole(RoleMenuRequestDTO requestDto, String currentUser) {
        Role role = roleRepository.findById(requestDto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role tidak ditemukan dengan ID: " + requestDto.getRoleId()));

        // Hapus hak akses lama untuk role ini terlebih dahulu (Replace strategy)
        roleMenuRepository.deleteByIdRoleId(role.getRoleId());

        // Masukkan hak akses menu yang baru
        if (requestDto.getMenuIds() != null && !requestDto.getMenuIds().isEmpty()) {
            for (Long menuId : requestDto.getMenuIds()) {
                Menu menu = menuRepository.findById(menuId)
                        .orElseThrow(() -> new RuntimeException("Menu tidak ditemukan dengan ID: " + menuId));

                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRole(role);
                roleMenu.setMenu(menu);
                roleMenu.setCreatedDate(LocalDate.now());
                roleMenu.setCreatedBy(currentUser != null ? currentUser : "System");

                roleMenuRepository.save(roleMenu);
            }
        }
    }
}
