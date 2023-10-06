package com.Kafka.OrderService.Kafka;

import com.Kafka.Maindomain.Dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    @Autowired
    private NewTopic topic;

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendmessage(OrderEvent event) {
        LOGGER.info(String.format("order event => %s", event.toString()));

        // Build the message
        Message<OrderEvent> message = MessageBuilder.withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        // You may want to send this message using kafkaTemplate
        kafkaTemplate.send(message);
    }
}
