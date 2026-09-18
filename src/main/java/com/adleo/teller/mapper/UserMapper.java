package com.adleo.teller.mapper;

import com.adleo.teller.dto.UserRequestDTO;
import com.adleo.teller.dto.UserResponseDTO;
import com.adleo.teller.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Mengubah Request DTO menjadi Entity (untuk disimpan ke Database)
    public User toEntity(UserRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setNama(dto.getNama());
        user.setAlamat(dto.getAlamat());
        user.setEmail(dto.getEmail());
        user.setTelepon(dto.getTelepon());
        user.setProgramName(dto.getProgramName());
        return user;
    }

    // Mengubah Entity menjadi Response DTO (untuk dikirim ke Client/Postman)
    public UserResponseDTO toResponseDTO(User user) {
        if (user == null) {
            return null;
        }
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setNama(user.getNama());
        dto.setAlamat(user.getAlamat());
        dto.setEmail(user.getEmail());
        dto.setTelepon(user.getTelepon());
        dto.setProgramName(user.getProgramName());
        dto.setCreatedDate(user.getCreatedDate());
        return dto;
    }
}