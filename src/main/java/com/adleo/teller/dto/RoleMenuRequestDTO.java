package com.adleo.teller.dto;

import lombok.Data;
import java.util.List;

@Data
public class RoleMenuRequestDTO {
    private Long roleId;
    private List<Long> menuIds; // Daftar ID menu yang diizinkan untuk role ini
}