package com.ngenia.rabbitmq.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    private static Integer nbConsumedMessages = 0;

    public Integer getNbConsumedMessages(){return nbConsumedMessages;}

    @RabbitListener(queues = {"#{'${queue.name}'.split(',')}"})
    public void handle(@Payload String message) {
        logger.info("[" + ++nbConsumedMessages + "] Received: '" + message + "'");
    }
}