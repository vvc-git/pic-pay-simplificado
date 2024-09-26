package com.picpaysimplificado.picpaysimplificado.repositories;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



// A interface UserRepository define um "modelo" para operações de acesso ao banco de dados.
// Ela estende JpaRepository, uma interface do Spring Data JPA, que fornece métodos prontos para operações comuns,
// como salvar, buscar, atualizar e deletar registros. Assim, não é necessário implementar manualmente esses métodos.
public interface UserRepository extends JpaRepository<User, Long> {
    // Seguindo a especificação JPA, ele sabe implementar as classes abaixo.
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(Long id);
}
