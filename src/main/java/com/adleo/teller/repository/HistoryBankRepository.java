package com.adleo.teller.repository;

import com.adleo.teller.entity.HistoryBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryBankRepository extends JpaRepository<HistoryBank, String> {
}
