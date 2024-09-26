package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.dtos.TransactionDTO;
import com.picpaysimplificado.picpaysimplificado.repositories.TransactionRepository;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    // Classe do Spring que possibilita realizar requisições HTTP.
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {

        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.authorizeTransaction(sender,transaction.value());
        if (!isAuthorized) {
            throw new Exception("Transação não autorizada");
        }

        // 1. Cria a transação objeto Transação e seta seus atributos
        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        // 2. Atualiza os Usuários
        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        // 3. Salva as modificações no banco
        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        // 4. Envia a notificação para os usuários
        this.notificationService.sendNotification(sender, "Transação realizada com sucesso");
        this.notificationService.sendNotification(receiver, "Transação recebida com sucesso");

        return newTransaction;
    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {

        // ResponseEntity: Tipo genérico no Java utilizado para representar TODA a resposta HTTP (STATUS + CABEÇALHO + CORPO)
        // Parâmetro <> do ResponseEntity: O parâmetro <Map> indica que o corpo da resposta (body) será um objeto do tipo Map.
        // Map.class: indica que a resposta da requisição feita pelo getForEntity será tratada como um Map.
        // Por exemplo, um JSON, ele será convertido automaticamente para um Map
        // ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);


        //        if(authorizationResponse.getStatusCode() == HttpStatus.OK){
        //            String message = (String) authorizationResponse.getBody().get("message");
        //            return "Autorizado".equalsIgnoreCase(message);
        //        } else  return false;

        return true;

    }
}
