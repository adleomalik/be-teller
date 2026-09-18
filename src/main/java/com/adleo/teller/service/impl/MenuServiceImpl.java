package com.adleo.teller.service.impl;

import com.adleo.teller.dto.MenuRequestDTO;
import com.adleo.teller.dto.MenuResponseDTO;
import com.adleo.teller.entity.Menu;
import com.adleo.teller.mapper.MenuMapper;
import com.adleo.teller.repository.MenuRepository;
import com.adleo.teller.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuResponseDTO> getAllMenu() {
        List<Menu> menu = menuRepository.findAll();
        return menu.stream()
                .map(menuMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MenuResponseDTO getMenuById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu tidak ditemukan dengan ID: " + id));
        return menuMapper.toResponseDTO(menu);
    }

    @Override
    public MenuResponseDTO createMenu(MenuRequestDTO requestDto, String currentUser) {
        Menu menu = menuMapper.toEntity(requestDto);
        menu.setCreatedDate(LocalDate.now());
        menu.setCreatedBy(currentUser != null ? currentUser : "System");
        Menu savedMenu = menuRepository.save(menu);
        return menuMapper.toResponseDTO(savedMenu);
    }

    @Override
    public MenuResponseDTO updateMenu(Long id, MenuRequestDTO requestDto, String currentUser) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu tidak ditemukan dengan ID: " + id));
        menuMapper.updateEntityFromDTO(requestDto, menu);
        menu.setUpdatedDate(LocalDate.now());
        menu.setUpdatedBy(currentUser != null ? currentUser : "System");
        Menu updatedMenu = menuRepository.save(menu);
        return menuMapper.toResponseDTO(updatedMenu);
    }

    @Override
    public void deleteMenu(Long id) {
        if (!menuRepository.existsById(id)) {
            throw new RuntimeException("Menu tidak ditemukan dengan ID: " + id);
        }
        menuRepository.deleteById(id);
    }
}
