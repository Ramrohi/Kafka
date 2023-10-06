package com.Kafka.OrderService.Controller;

import com.Kafka.Maindomain.Dto.Order;
import com.Kafka.Maindomain.Dto.OrderEvent;
import com.Kafka.OrderService.Kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;
    @PostMapping("/Order")
    public String PlaceOrder(@RequestBody Order order)
    {
        order.setId(UUID.randomUUID().toString());
        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setMessage("Pending");
        orderEvent.setStatus("Order Staus is pending");
        orderEvent.setOrder(order);
        orderProducer.sendmessage(orderEvent);
        return "OrderPlaceSuccessFully";
    }
}