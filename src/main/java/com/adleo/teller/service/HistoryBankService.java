package com.adleo.teller.service;

import com.adleo.teller.dto.HistoryBankRequestDTO;
import com.adleo.teller.dto.HistoryBankResponseDTO;

import java.util.List;
import java.util.Optional;

public interface HistoryBankService {
    List<HistoryBankResponseDTO>getAllHistory();
    Optional<HistoryBankResponseDTO>getHistoryBankById(String id);
    HistoryBankResponseDTO createHistory(HistoryBankRequestDTO requestDTO);
    HistoryBankResponseDTO updateHistory(String id, HistoryBankResponseDTO responseDTO);
    void deleteHistory(String id);

}
