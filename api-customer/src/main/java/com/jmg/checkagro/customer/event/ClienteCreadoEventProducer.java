package com.jmg.checkagro.customer.event;


import com.jmg.checkagro.customer.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClienteCreadoEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public ClienteCreadoEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void publishClienteCreado(ClienteCreadoEventProducer.Data message){
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,RabbitMQConfig.TOPIC_CLIENTE_CREADO,message);
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
