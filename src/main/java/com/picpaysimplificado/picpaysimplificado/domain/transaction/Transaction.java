package com.picpaysimplificado.picpaysimplificado.domain.transaction;


import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//  JPA-related: Utilizada para informar que uma classe também é uma entidade.
//  A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados
@Entity(name="transactions")
@Table(name ="transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    //  JPA-related
    @ManyToOne // 1x Usuário (que envia) vai poder MUITAS transações
    @JoinColumn(name = "sender_id")
    private User sender;

    //  JPA-related
    @ManyToOne // 1x Usuário (que recebe) vai poder MUITAS transações
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;



}
