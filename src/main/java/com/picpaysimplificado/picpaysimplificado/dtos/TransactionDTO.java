package com.picpaysimplificado.picpaysimplificado.dtos;

import java.math.BigDecimal;

// DTO (Data Transfer Object): Um objeto usado para transportar dados entre diferentes camadas da aplicação.

// Record: Uma forma concisa e imutável de representar objetos que carregam dados. Ideal para DTOs, pois gera automaticamente
// construtor, getters, equals, hashCode e toString, reduzindo código boilerplate e garantindo a imutabilidade dos dados.
public record TransactionDTO(BigDecimal value, Long senderId, long receiverId) {
}
