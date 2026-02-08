package com.alibou.ecommerce.exception;

import jakarta.validation.constraints.NotNull;public class ProductPurchaseException extends RuntimeException {
    public ProductPurchaseException(String s) {
        super(s);
    }
}
