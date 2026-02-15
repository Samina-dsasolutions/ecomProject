package com.alibou.ecommerce.kafka.order;

import org.apache.kafka.common.protocol.types.Field;

import java.math.BigDecimal;

public record Product(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
