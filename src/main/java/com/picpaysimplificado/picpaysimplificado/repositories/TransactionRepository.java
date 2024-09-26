package com.picpaysimplificado.picpaysimplificado.repositories;

import com.picpaysimplificado.picpaysimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

// A interface UserRepository define um "modelo" para operações de acesso ao banco de dados.
// Ela estende JpaRepository, uma interface do Spring Data JPA, que fornece métodos prontos para operações comuns,
// como salvar, buscar, atualizar e deletar registros. Assim, não é necessário implementar manualmente esses métodos.
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
