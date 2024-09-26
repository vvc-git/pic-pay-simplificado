package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.rmi.server.ExportException;
import java.text.Bidi;
import java.util.List;

public class UserService {

    // Spring que vai instanciar e gerenciar
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws  Exception{

        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário do tipo Lojista não pode realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficinte");
        }

    }

    // Métodos para garantir que todas as operações relacionadas a usuários sejam realizadas exclusivamente através do UserService,
    // evitando o acesso direto ao UserRepository por outras camadas e promovendo a separação de responsabilidades.
    public void saveUser(User user){
        this.repository.save(user);
    }
    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    // Método para criar usuário
    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }







}
