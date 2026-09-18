package com.adleo.teller.service.impl;

import com.adleo.teller.dto.UserRequestDTO;
import com.adleo.teller.dto.UserResponseDTO;
import com.adleo.teller.entity.User;
import com.adleo.teller.mapper.UserMapper;
import com.adleo.teller.repository.UserRepository;
import com.adleo.teller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserResponseDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponseDTO);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        // 1. Ubah RequestDTO menjadi Entity
        User user = userMapper.toEntity(requestDTO);

        // 2. Isi data audit otomatis
        user.setCreatedDate(LocalDateTime.now());
        user.setCreatedBy("SYSTEM"); // Bisa diubah sesuai user yang sedang login nantinya

        // 3. Simpan ke database
        User savedUser = userRepository.save(user);

        // 4. Ubah kembali ke ResponseDTO untuk dikembalikan
        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO requestDTO) {
        // 1. Cari user berdasarkan ID, jika tidak ada lempar error/exception
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User dengan ID " + id + " tidak ditemukan"));

        // 2. Perbarui field data yang diizinkan untuk diubah
        existingUser.setUsername(requestDTO.getUsername());
        existingUser.setPassword(requestDTO.getPassword()); // atau sesuaikan jika password opsional
        existingUser.setNama(requestDTO.getNama());
        existingUser.setAlamat(requestDTO.getAlamat());
        existingUser.setEmail(requestDTO.getEmail());
        existingUser.setTelepon(requestDTO.getTelepon());
        existingUser.setProgramName(requestDTO.getProgramName());

        // 3. Set waktu update otomatis
        existingUser.setUpdatedDate(LocalDateTime.now());
        existingUser.setUpdatedBy("SYSTEM"); // atau user yang sedang login

        // 4. Simpan perubahan ke database
        User updatedUser = userRepository.save(existingUser);

        // 5. Kembalikan dalam bentuk ResponseDTO
        return userMapper.toResponseDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}