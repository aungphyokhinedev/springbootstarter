package com.payplus.customer;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQ {
    @Value("${spring.application.name}")
    private String name;

    private final String queue = "customer";
    @Bean
    Queue queue() {
        return new Queue(name, false);
    }

    @RabbitListener(queues = queue)
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
    }
}
