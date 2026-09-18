package com.adleo.teller.mapper;

import com.adleo.teller.dto.HistoryBankRequestDTO;
import com.adleo.teller.dto.HistoryBankResponseDTO;
import com.adleo.teller.entity.HistoryBank;
import org.springframework.stereotype.Component;

@Component
public class HistoryBankMapper {
    public HistoryBank toEntity(HistoryBankRequestDTO dto) {
        if(dto == null){
            return null;
        }

        HistoryBank historyBank = new HistoryBank();
//        historyBank.setIdHistoryBank(dto.getIdHistoryBank());
//        historyBank.setTanggal(dto.getTanggal());
        historyBank.setNorek(dto.getNoRek());
        historyBank.setStatusKet(dto.getStatusKet());
        historyBank.setNama(dto.getNama());
        historyBank.setUang(dto.getUang());
        historyBank.setNorekDituju(dto.getNorekDituju());
        historyBank.setNoTlp(dto.getNoTlp());
        return historyBank;
    }

    public HistoryBankResponseDTO toResponseDTO(HistoryBank historyBank){
        if(historyBank == null){
            return null;
        }
        HistoryBankResponseDTO dto = new HistoryBankResponseDTO();
        dto.setIdHistoryBank(historyBank.getIdHistoryBank());
        dto.setTanggal(historyBank.getTanggal());
        dto.setNoRek(historyBank.getNorek());
        dto.setStatusKet(historyBank.getStatusKet());
        dto.setNama(historyBank.getNama());
        dto.setUang(historyBank.getUang());
        dto.setNorekDituju(historyBank.getNorekDituju());
        dto.setNoTlp(historyBank.getNoTlp());
        return dto;
    }
}