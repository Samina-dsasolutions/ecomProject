package com.alibou.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CustomerResponse (
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
)

{

}
