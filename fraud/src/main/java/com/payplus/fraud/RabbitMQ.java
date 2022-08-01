package com.payplus.fraud;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQ {
    private final String queue = "fraud";
    @Bean
    Queue queue() {
        return new Queue(queue, false);
    }

    @RabbitListener(queues = queue)
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
    }
}
