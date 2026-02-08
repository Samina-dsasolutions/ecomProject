package com.alibou.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByIdInOrderById(List<@NotNull(message = "product is mandatory") Integer> productIds);
}
