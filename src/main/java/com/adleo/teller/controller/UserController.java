package com.adleo.teller.controller;

import com.adleo.teller.dto.UserRequestDTO;
import com.adleo.teller.dto.UserResponseDTO;
import com.adleo.teller.entity.User;
import com.adleo.teller.repository.UserRepository;
import com.adleo.teller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // Endpoint Login Sederhana: POST /api/users/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        // Cari user berdasarkan username
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Cek password (bisa disesuaikan jika pakai enkripsi/BCrypt)
            if (user.getPassword().equals(loginRequest.getPassword())) {
                // Login sukses, kembalikan data user (password bisa dikosongkan dulu untuk keamanan)
                user.setPassword(null);
                return ResponseEntity.ok(user);
            }
        }

        // Jika gagal
        return ResponseEntity.status(401).body("Username atau password salah!");
    }

    // 1. Mengambil semua data user
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // 2. Mengambil data user berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 3. Menambah data user baru
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO requestDTO) {
        UserResponseDTO newUser = userService.createUser(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // 4. Menghapus data user berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // 5. Update User (Memperbarui data user berdasarkan ID)
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDTO requestDTO) {
        UserResponseDTO updatedUser = userService.updateUser(id, requestDTO);
        return ResponseEntity.ok(updatedUser);
    }
}