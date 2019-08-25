package com.ngenia.rabbitmq.consumer.controller;

import com.ngenia.rabbitmq.consumer.service.MessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private MessageConsumer messageConsumer;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String getConsumedMessages() {
        return "{\"Number of Consumed Messages\": " + messageConsumer.getNbConsumedMessages() + "}";
    }
}