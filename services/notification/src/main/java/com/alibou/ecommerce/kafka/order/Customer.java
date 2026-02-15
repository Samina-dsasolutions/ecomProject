package com.alibou.ecommerce.kafka.order;

import org.apache.kafka.common.protocol.types.Field;

public record Customer(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
