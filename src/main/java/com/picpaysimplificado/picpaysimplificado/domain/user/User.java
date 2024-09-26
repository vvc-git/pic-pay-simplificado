package com.picpaysimplificado.picpaysimplificado.domain.user;

import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

// Indica que a classe é uma entidade JPA, vinculando-a a uma tabela de mesmo nome no banco de dados.
// Isso permite que a JPA gerencie automaticamente as operações de persistência para essa entidade.
@Entity(name="users")
@Table(name ="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// ??
@EqualsAndHashCode(of="id")
public class User {
        // Usada para marcar um campo como a chave primária da entidade.
        @Id
        // Usada para especificar a estratégia de geração automática do valor do campo anotado com @id
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

        public User(UserDTO data) {
                this.firstName = data.firstName();
                this.lastName = data.lastName();
                this.balance = data.balance();
                this.userType = data.userType();
                this.password = data.password();
                this.document = data.document();
                this.email = data.email();
        }


}
