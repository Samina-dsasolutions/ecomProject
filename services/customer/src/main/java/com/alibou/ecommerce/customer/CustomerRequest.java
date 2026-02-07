package com.alibou.ecommerce.customer;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(

    String id,
    @NotNull(message = "customer first name is require")
    String firstName,
    @NotNull(message = "customer last name is require")
    String lastName,
    @NotNull(message = "customer email is require")
    @Email(message = "customer email is not a valid email address")
    String email,
    Address address
){

}
