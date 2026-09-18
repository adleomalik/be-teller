package com.adleo.teller.service;

import com.adleo.teller.dto.MenuRequestDTO;
import com.adleo.teller.dto.MenuResponseDTO;

import java.util.List;

public interface MenuService {
    List<MenuResponseDTO>getAllMenu();
    MenuResponseDTO getMenuById(Long id);
    MenuResponseDTO createMenu(MenuRequestDTO requestDto, String currentUser);
    MenuResponseDTO updateMenu(Long id, MenuRequestDTO requestDto, String currentUser);
    void deleteMenu(Long id);
}
