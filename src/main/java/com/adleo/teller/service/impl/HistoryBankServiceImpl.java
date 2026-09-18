package com.adleo.teller.service.impl;

import com.adleo.teller.dto.HistoryBankRequestDTO;
import com.adleo.teller.dto.HistoryBankResponseDTO;
import com.adleo.teller.dto.UserResponseDTO;
import com.adleo.teller.entity.HistoryBank;
import com.adleo.teller.mapper.HistoryBankMapper;
import com.adleo.teller.repository.HistoryBankRepository;
import com.adleo.teller.service.HistoryBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoryBankServiceImpl implements HistoryBankService {

    @Autowired
    private HistoryBankRepository historyBankRepository;

    @Autowired
    private HistoryBankMapper historyBankMapper;

    @Override
    public List<HistoryBankResponseDTO> getAllHistory() {
        List<HistoryBank> historyBanks = historyBankRepository.findAll();
        return historyBanks.stream()
                .map(historyBankMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HistoryBankResponseDTO> getHistoryBankById(String id) {
        return historyBankRepository.findById(id)
                .map(historyBankMapper::toResponseDTO);
    }

    @Override
    public HistoryBankResponseDTO createHistory(HistoryBankRequestDTO requestDTO) {
        HistoryBank historyBank = historyBankMapper.toEntity(requestDTO);

        String customId = generateCustomId();
        historyBank.setIdHistoryBank(customId);

        historyBank.setTanggal(LocalDateTime.now());

        HistoryBank savedHistoryBank = historyBankRepository.save(historyBank);

        return historyBankMapper.toResponseDTO(savedHistoryBank);
    }

    @Override
    public HistoryBankResponseDTO updateHistory(String id, HistoryBankResponseDTO responseDTO) {
        return null;
    }

    @Override
    public void deleteHistory(String id) {
        historyBankRepository.deleteById(id);
    }

    // Method pembantu untuk membuat format ID unik
    private String generateCustomId() {
        // Format tanggal hari ini, misal: 20260909
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // Ambil nomor urut (bisa dari total data di database + 1, atau random 4 digit)
        long count = historyBankRepository.count() + 1;
        String sequencePart = String.format("%04d", count); // Hasilnya: 0001, 0002, dst.

        // Gabungkan menjadi: TRX-20260909-0001
        return "TRX-" + datePart + "-" + sequencePart;
    }
}
