package com.ngenia.rabbitmq.sender.controller;

import com.ngenia.rabbitmq.sender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
    public String send(@RequestParam("message") String message) {
        messageSender.send(message);
        return "{\"Message Sent Successfully\": " + message + "}";
    }
}