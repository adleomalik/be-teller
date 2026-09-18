package com.adleo.teller.controller;

import com.adleo.teller.dto.RoleMenuRequestDTO;
import com.adleo.teller.dto.MenuResponseDTO;
import com.adleo.teller.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-menus")
@CrossOrigin(origins = "*")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    // Mendapatkan daftar menu yang dimiliki oleh suatu role tertentu
    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<MenuResponseDTO>> getMenusByRole(@PathVariable Long roleId) {
        return ResponseEntity.ok(roleMenuService.getMenusByRoleId(roleId));
    }

    // Menyimpan / memperbarui hak akses menu untuk suatu role
    @PostMapping("/assign")
    public ResponseEntity<String> assignMenusToRole(@RequestBody RoleMenuRequestDTO requestDto, @RequestParam(required = false) String currentUser) {
        roleMenuService.assignMenusToRole(requestDto, currentUser);
        return ResponseEntity.ok("Hak akses menu berhasil diperbarui untuk role tersebut.");
    }
}