package com.ngenia.rabbitmq.sender;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Map;

@SpringBootApplication
public class Sender {

    @Value("${message.exchange}")
    private String exchange;

    @Value("${message.routingKey}")
    private String routingKey;

    @Bean
    public Exchange exchange() {
        return new Exchange() {
            @Override
            public String getName() {
                return exchange;
            }

            @Override
            public String getType() {
                return null;
            }

            @Override
            public boolean isDurable() {
                return false;
            }

            @Override
            public boolean isAutoDelete() {
                return false;
            }

            @Override
            public Map<String, Object> getArguments() {
                return null;
            }

            @Override
            public boolean isDelayed() {
                return false;
            }

            @Override
            public boolean isInternal() {
                return false;
            }

            @Override
            public boolean shouldDeclare() {
                return false;
            }

            @Override
            public Collection<?> getDeclaringAdmins() {
                return null;
            }

            @Override
            public boolean isIgnoreDeclarationExceptions() {
                return false;
            }
        };
    }

    @Bean
    public Queue queue() {
        return new Queue(routingKey, true);
    }

    public static void main(String[] args) {
        SpringApplication.run(Sender.class, args);
    }
}