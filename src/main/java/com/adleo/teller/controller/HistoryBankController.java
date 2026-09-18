package com.adleo.teller.controller;

import com.adleo.teller.dto.HistoryBankRequestDTO;
import com.adleo.teller.dto.HistoryBankResponseDTO;
import com.adleo.teller.dto.UserRequestDTO;
import com.adleo.teller.service.HistoryBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historyBank")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoryBankController {
    @Autowired
    private HistoryBankService historyBankService;

    @GetMapping
    public ResponseEntity<List<HistoryBankResponseDTO>> getAllHistory() {
        List<HistoryBankResponseDTO> historyBank = historyBankService.getAllHistory();
        return ResponseEntity.ok(historyBank);
    }

    @PostMapping
    public ResponseEntity<HistoryBankResponseDTO> createdHistoryBank(@RequestBody HistoryBankRequestDTO requestDTO) {
        HistoryBankResponseDTO newHistory = historyBankService.createHistory(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHistory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryBankResponseDTO> getUserById(@PathVariable String id){
        return historyBankService.getHistoryBankById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable String id){
        historyBankService.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }
}
