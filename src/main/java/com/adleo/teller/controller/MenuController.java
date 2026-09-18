package com.adleo.teller.controller;

import com.adleo.teller.dto.MenuRequestDTO;
import com.adleo.teller.dto.MenuResponseDTO;
import com.adleo.teller.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<MenuResponseDTO>> getAllMenus() {
        return ResponseEntity.ok(menuService.getAllMenu());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuResponseDTO> getMenuById(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.getMenuById(id));
    }

    @PostMapping
    public ResponseEntity<MenuResponseDTO> createMenu(@RequestBody MenuRequestDTO requestDto, @RequestParam(required = false) String currentUser) {
        return ResponseEntity.ok(menuService.createMenu(requestDto, currentUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuResponseDTO> updateMenu(@PathVariable Long id, @RequestBody MenuRequestDTO requestDto, @RequestParam(required = false) String currentUser) {
        return ResponseEntity.ok(menuService.updateMenu(id, requestDto, currentUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.ok("Menu berhasil dihapus.");
    }
}