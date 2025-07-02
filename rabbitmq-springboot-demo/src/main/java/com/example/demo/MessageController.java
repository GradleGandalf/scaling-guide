package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final RabbitTemplate template;

    public MessageController(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/api/send")
    public void send(@RequestBody String payload) {
        template.convertAndSend(RabbitConfig.QUEUE, payload);
    }
}
