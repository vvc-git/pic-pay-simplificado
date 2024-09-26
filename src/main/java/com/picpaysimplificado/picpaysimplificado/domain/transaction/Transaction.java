package com.picpaysimplificado.picpaysimplificado.domain.transaction;


import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Indica que a classe é uma entidade JPA, vinculando-a a uma tabela de mesmo nome no banco de dados.
// Isso permite que a JPA gerencie automaticamente as operações de persistência para essa entidade.
@Entity(name="transactions")
@Table(name ="transactions")
@Getter
@Setter
@AllArgsConstructor // Cria um construtor que recebe todos os atributos da classe como argumentos.
@NoArgsConstructor // Cria um construtor sem parâmetros.
@EqualsAndHashCode(of="id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    // Define uma relação muitos-para-um, indicando que um usuário pode estar associado a várias transações,
    //// mas cada transação tem apenas um usuário (o remetente) associado.
    @ManyToOne
    // Especifica a coluna na tabela de transações que armazenará a chave estrangeira
    // referenciando o usuário (remetente) responsável pela transação.
    @JoinColumn(name = "sender_id")
    private User sender;

    //  JPA-related
    @ManyToOne // 1x Usuário (que recebe) vai poder MUITAS transações
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;

}
