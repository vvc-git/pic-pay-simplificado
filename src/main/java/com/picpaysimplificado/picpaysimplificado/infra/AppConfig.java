package com.picpaysimplificado.picpaysimplificado.infra;

import com.picpaysimplificado.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.picpaysimplificado.services.NotificationService;
import com.picpaysimplificado.picpaysimplificado.services.TransactionService;
import com.picpaysimplificado.picpaysimplificado.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {return new RestTemplate();}

    @Bean
    public UserService userService() {return new UserService();}

    @Bean
    public TransactionService transactionService() {return new TransactionService();}

    @Bean
    public NotificationService notificationService() {return new NotificationService();}


}
