package com.adleo.teller.mapper;

import com.adleo.teller.dto.MenuRequestDTO;
import com.adleo.teller.dto.MenuResponseDTO;
import com.adleo.teller.entity.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {

    public MenuResponseDTO toResponseDTO(Menu menu) {
        if (menu == null) return null;
        MenuResponseDTO dto = new MenuResponseDTO();
        dto.setMenuId(menu.getMenuId());
        dto.setNama(menu.getNama());
        dto.setIcon(menu.getIcon());
        dto.setUrl(menu.getUrl());
        dto.setProgramName(menu.getProgramName());
        dto.setCreatedDate(menu.getCreatedDate());
        dto.setCreatedBy(menu.getCreatedBy());
        dto.setUpdatedDate(menu.getUpdatedDate());
        dto.setUpdatedBy(menu.getUpdatedBy());
        return dto;
    }

    public Menu toEntity(MenuRequestDTO requestDto) {
        if (requestDto == null) return null;
        Menu menu = new Menu();
        menu.setNama(requestDto.getNama());
        menu.setIcon(requestDto.getIcon());
        menu.setUrl(requestDto.getUrl());
        menu.setProgramName(requestDto.getProgramName());
        return menu;
    }

    public void updateEntityFromDTO(MenuRequestDTO requestDto, Menu menu) {
        if (requestDto == null || menu == null) return;
        menu.setNama(requestDto.getNama());
        menu.setIcon(requestDto.getIcon());
        menu.setUrl(requestDto.getUrl());
        menu.setProgramName(requestDto.getProgramName());
    }
}