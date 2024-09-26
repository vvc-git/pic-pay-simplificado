package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    // Função para enviar notificações pro endpoint especificado.
    public void sendNotification(User user, String message) throws Exception {

        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        // ResponseEntity: Tipo genérico no Java utilizado para representar TODA a resposta HTTP (STATUS + CABEÇALHO + CORPO)
        // Parâmetro <> do ResponseEntity: O parâmetro <String> indica que o corpo da resposta (body) será um objeto do tipo String.
        // Por exemplo, um JSON, ele será convertido automaticamente para um String
        //        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);
        //
        //        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
        //            System.out.println("erro ao enviar notificacao");
        //            throw new Exception("Serviço de notificação está fora do ar");
        //        }

        System.out.println("Enviou notificacao");

    }
}
