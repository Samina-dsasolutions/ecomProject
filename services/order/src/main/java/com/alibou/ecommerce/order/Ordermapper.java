package com.alibou.ecommerce.order;


import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class Ordermapper {
    public Order toOrder(@Valid OrderRequest request) {
        return Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }
}
