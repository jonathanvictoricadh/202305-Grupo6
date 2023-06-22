package com.jmg.checkagro.check.event;

import com.jmg.checkagro.check.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteCreadoEventConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_CLIENTE_CREADO)
    public void listen(ClienteCreadoEventConsumer.Data message){
            System.out.print("NOMBRE DEL CLIENTE "+ message.businessName);
            //procesamiento
        }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Data{
        private String businessName;
        private String id;
        private String documentNumber;
    }

}
