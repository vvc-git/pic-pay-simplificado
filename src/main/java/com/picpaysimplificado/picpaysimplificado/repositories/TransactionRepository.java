package com.picpaysimplificado.picpaysimplificado.repositories;

import com.picpaysimplificado.picpaysimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface é um modelo que contém métodos que outras classes devem implementar.
// A Interface UserRepository está herdando de uma interface do Spring Data chamada JpaRepository.
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
