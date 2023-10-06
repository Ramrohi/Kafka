package com.Kafka.Maindomain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private  String id;
    private String name;
    private  int qty;
    private double price;
}
