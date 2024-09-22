package com.picpaysimplificado.picpaysimplificado.repositories;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// Interface é um modelo que contém métodos que outras classes devem implementar.
// A Interface UserRepository está herdando de uma interface do Spring Data chamada JpaRepository.
public interface UserRepository extends JpaRepository<User, Long> {
    // Seguindo a especificação JPA, ele sabe implementaar as classes abaixo.
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(Long id);
}
