package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private final MessageRepository repository;

    public MessageListener(MessageRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(String payload) {
        repository.save(new MessageEntity(payload));
    }
}
