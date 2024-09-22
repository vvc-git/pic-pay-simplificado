package com.picpaysimplificado.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

//  JPA-related: Utilizada para informar que uma classe também é uma entidade.
//  A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados
@Entity(name="users")
@Table(name ="users")
@Getter
@Setter
@AllArgsConstructor

// ??
@EqualsAndHashCode(of="id")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String firstName;
        private String lastName;

        @Column(unique = true)
        private String document;

        @Column(unique = true)
        private String email;

        private String password;
        private BigDecimal balance;

        //  Essa na
        @Enumerated(EnumType.STRING)
        private UserType userType;


}
